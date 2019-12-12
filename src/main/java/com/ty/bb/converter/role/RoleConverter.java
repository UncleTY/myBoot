package com.ty.bb.converter.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleConverter {
    RoleDTO toDTO(RoleDO roleDO);

    RoleDO toDO(RoleDTO roleDTO);
}
