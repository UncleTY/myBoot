package com.ty.bb.mapper.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import com.ty.bb.bean.role.RoleQuery;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface RoleMapper extends Mapper<RoleDO>, MySqlMapper<RoleDO> {
    RoleDTO queryRoleByRoleCode(RoleQuery roleQuery);
}
