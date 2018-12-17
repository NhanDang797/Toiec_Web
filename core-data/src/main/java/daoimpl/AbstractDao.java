package daoimpl;

import constant.CoreContant;
import dao.GenericDao;
import org.hibernate.*;
import utils.HibernateUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

// ke thua tu GenericDao
public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    //1. tao bien co kieu Class de goi theo tung class
    private Class<T> persistanceClass;

    public AbstractDao() {
        /*
         * 1.ham dung tra ve ten class khi goi den .
         * 2.getActualTypeArguments()[1]  >> lay vi tri T {{ <ID extends Serializable, T> }}
         * */

        this.persistanceClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //2. viet ham chuyen doi persistanceClass thanh String de thuc hien truy van
    public String getPersistanceClassName() {
        return persistanceClass.getSimpleName();
    }

    /*
     * Lưu ý khi viết đối tượng Session : viết riêng từng hàm .
     * */

    // API Select >> findAll
    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();// bắt đầu 1 transaction
        try {
            //HQL
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistanceClassName()); // tên 1 EntityClass
            Query query = session.createQuery(sql.toString()); // truy vân dữ liệu (select trong SQL)
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();  // đóng phiên giao dịch
        }

        return list;
    }

    // API Update >> merge
    public T update(T entity) {
        T result = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object object = session.merge(entity); // 1 đối tượng update
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    // API save >> persits
    public void save(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity); //(insert trong sql)
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public T findById(ID id) {
        T result = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            result = session.get(persistanceClass, id);
            if (result == null) {
                throw new ObjectNotFoundException("NOT FOUND " + id, null);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T> list = new ArrayList<T>();
        Object totalItems =0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("from ");
            sql.append(getPersistanceClassName());
            /*Kiểm tra dữ liệu*/
            if (property != null && value != null) {
                sql.append(" where ").append(property).append(" =:value");

            }
            if (sortExpression != null && sortDirection != null) {
                sql.append(" order by ").append(sortExpression);
                sql.append(" " + (sortDirection.equals(CoreContant.SORT_ASC)? "asc" : "desc"));
            }
            Query query1 = session.createQuery(sql.toString());
            if (value != null){
                query1.setParameter("value",value); // 118
            }
            list = query1.list(); // trả về 1 list phần tử

        //----------------------------------- end list

            StringBuilder sqlCount = new StringBuilder("select count(*) from ");
            sqlCount.append(getPersistanceClassName());
            if (property != null && value != null) {
                sqlCount.append(" where ").append(property).append(" =:value");
            }
            Query queryCount = session.createQuery(sqlCount.toString());
            if (value != null){
                queryCount.setParameter("value",value);
            }
            totalItems = queryCount.list().get(0); // trả về số phần tử của list
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return new Object[]{totalItems, list};
    }

    public Integer delete(List<ID> ids) {
        int count = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            /*tìm ID trùng với ID có trong list này*/
            for (ID item : ids) {
                T t = session.get(persistanceClass,item); // lấy ra row có ID là item
                session.delete(t);// xóa đối tượng t
                count++;
            }
            transaction.commit();
        }
        catch (HibernateException e){
            transaction.rollback();
            throw  e;
        }
        finally {
            session.close();
        }
        return count;
    }


}
