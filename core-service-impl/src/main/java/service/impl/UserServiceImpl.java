package service.impl;

import core.dto.UserDTO;
import core.utils.UserBeanUtil;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.UserEntity;
import service.UserService;

public class UserServiceImpl implements UserService {


    public UserDTO isUserExits(UserDTO dto) {
        UserDao userDao = new UserDaoImpl(); // nên khởi tạo riêng mỗi cái có 1 session riêng
        UserEntity entity = userDao.isUserExits(dto.getName(),dto.getPassword());// lấy 2 trường dư liệu
        return UserBeanUtil.entityToDTO(entity); // gọi hàm chuyển đổi entity thành dto
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.findRoleByUser(dto.getName(),dto.getPassword());// lấy 2 trường dư liệu
        return UserBeanUtil.entityToDTO(entity);
    }
}
