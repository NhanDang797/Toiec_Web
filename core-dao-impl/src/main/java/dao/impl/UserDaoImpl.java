package dao.impl;

import dao.UserDao;
import daoimpl.AbstractDao;
import entity.UserEntity;
import org.hibernate.*;
import utils.HibernateUtils;

public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao{

    public UserEntity isUserExits(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name =:name AND password =:password ");
            Query query = session.createQuery(sql.toString()); // truy vân dữ liệu (select trong SQL)
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();  // đóng phiên giao dịch
        }
        return entity;
    }

    public UserEntity findRoleByUser(String name, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity = new UserEntity();

        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name =:name AND password =:password ");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        }
        catch (HibernateException e) {
            transaction.rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return entity;
    }
}
