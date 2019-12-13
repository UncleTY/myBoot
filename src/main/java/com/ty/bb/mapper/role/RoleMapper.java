package com.ty.bb.mapper.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleQuery;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<RoleDO>{
    List<RoleDO> listRole(RoleQuery roleQuery);
    RoleDO queryRoleByCode(RoleQuery roleQuery);
}
