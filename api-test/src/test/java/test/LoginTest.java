package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.UserEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void isUserExits() {

        UserDao userDao = new UserDaoImpl();
        String name = "admin";
        String pass = "123";
        UserEntity entity = userDao.isUserExits(name, pass);

        if (entity != null) {
            log.error("OK");
        }
        else {
            log.error("Fail");
        }

    }

    @Test
    public void findRoleByUser() {
        UserDao userDao = new UserDaoImpl();
        String name = "admin";
        String pass = "123";
        UserEntity entity = userDao.findRoleByUser(name, pass);
        log.error(entity.getRoleEntity().getRoleID() +" -- "+ entity.getRoleEntity().getName());

    }
}
