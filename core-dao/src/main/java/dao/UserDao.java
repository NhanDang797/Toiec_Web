package dao;

import entity.UserEntity;

public interface UserDao extends GenericDao<Integer , UserEntity> {
    // tạo 2 hàm riêng kiểm tra tài khoản có tồn tại hay không và Kiểm tra quyền của tài khoản đó
    //1 : kiểm tra tồn tại
    UserEntity isUserExits(String name , String password);
    //2 : Kiểm tra quyền
    UserEntity findRoleByUser(String name , String password);

}
