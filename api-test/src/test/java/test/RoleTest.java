package test;

import dao.RoleDao;
import dao.impl.RoleDaoImpl;
import entity.RoleEntity;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RoleTest {
    // API findAll
    @Test // anotation >> tro thành hàm để Test
    public void checkFindAll(){

        RoleDao roleDao = new RoleDaoImpl(); // khởi tạo 1 class impliment từ RoleDao
        List<RoleEntity> list = roleDao.findAll();
    }

    // API Update
    @Test
    public void checkUpdateRole(){
         RoleDao roleDao = new RoleDaoImpl();
         RoleEntity roleEntity = new RoleEntity();
         // lấy ra row cần update
         roleEntity.setRoleID(2);
         roleEntity.setName("User");
         roleDao.update(roleEntity);

    }
    // API Save
    @Test
    public void checkSaveRole(){
         RoleDao roleDao = new RoleDaoImpl();
         RoleEntity roleEntity = new RoleEntity();
         roleEntity.setRoleID(3);
         roleEntity.setName("Manager");
         roleDao.save(roleEntity);
    }
    // API findByID
    @Test
    public void checkFindByRoleID() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity roleEntity = roleDao.findById(3);

    }
    @Test
    public void checkFindByPropertyRole(){
        RoleDao roleDao = new RoleDaoImpl();
        String a = null;
        Object b  = null;
        String c = null;
        String d = null;
        Object[] objects= roleDao.findByProperty(a,b,c,d);
    }
    @Test
    public void checkDeleteRole(){
        RoleDao roleDao = new RoleDaoImpl();
        List<Integer> listID = new ArrayList<Integer>();
        listID.add(1);
        listID.add(2);
        int count = roleDao.delete(listID);
    }
}
