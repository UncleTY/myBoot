package com.ty.bb.service.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleQuery;

import java.util.List;

public interface RoleService {
    public List<RoleDO> listRole(RoleQuery roleQuery);
}
