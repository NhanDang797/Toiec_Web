package core.utils;

import core.dto.RoleDTO;
import entity.RoleEntity;

public class RoleBeanUtil {
    public static RoleDTO entityToDTO(RoleEntity entity){
        RoleDTO dto = new RoleDTO();

        dto.setRoleID(entity.getRoleID());
        dto.setName(entity.getName());
        return dto;
    }

    public static RoleEntity dtoToEntity(RoleDTO dto){
        RoleEntity entity = new RoleEntity();

        entity.setRoleID(dto.getRoleID());
        entity.setName(dto.getName());

        return entity;
    }


}

