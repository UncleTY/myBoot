package com.ty.bb.service.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import com.ty.bb.bean.role.RoleQuery;

import java.util.List;

public interface RoleService {
    List<RoleDO> listRole(RoleQuery roleQuery);

    RoleDTO queryRole(RoleQuery roleQuery);

    RoleDTO queryRoleByRoleCode(RoleQuery roleQuery);

    void updateRoleCode(RoleDTO roleDTO);
}
