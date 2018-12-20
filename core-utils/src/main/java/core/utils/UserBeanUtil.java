package core.utils;

import core.dto.UserDTO;
import entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entityToDTO(UserEntity entity){ // lấy dữ liệu từ Entity đổ vào dto
        UserDTO dto = new UserDTO();

        dto.setUserID(entity.getUserID());
        dto.setName(entity.getName());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setCreateDate(entity.getCreateDate());

        dto.setRoleDTO(RoleBeanUtil.entityToDTO(entity.getRoleEntity()));
        return dto;
    }

    public static UserEntity dtoToEntity(UserDTO dto){ // lấy dữ liệu từ dto đổ vào Entity
        UserEntity entity = new UserEntity();

        entity.setUserID(dto.getUserID());
        entity.setName(dto.getName());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setCreateDate(dto.getCreateDate());

        entity.setRoleEntity(RoleBeanUtil.dtoToEntity(dto.getRoleDTO()));
        return entity;
    }


}
