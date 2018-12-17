package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    /*
        Bài 12
     */
    // khởi tạo hàm build SessionFacrory
    private static SessionFactory buildSessionFactory() {
        try {
            //khoi tao sessinFactory từ file Hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e){
            System.out.println("Initial SessionFactory Fail");
            throw  new ExceptionInInitializerError(e);
        }
    }

    private static final SessionFactory sessionFactory = buildSessionFactory();


    public static SessionFactory getSessionFactory() {
        return  sessionFactory;
    }
}

