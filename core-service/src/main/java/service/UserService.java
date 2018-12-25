package service;


import core.dto.UserDTO;

public interface UserService {
    UserDTO isUserExits(UserDTO dto);
    UserDTO findRoleByUser(UserDTO dto);


}


