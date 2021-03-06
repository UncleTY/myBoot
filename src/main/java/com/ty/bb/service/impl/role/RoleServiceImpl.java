package com.ty.bb.service.impl.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import com.ty.bb.bean.role.RoleQuery;
import com.ty.bb.converter.role.RoleConverter;
import com.ty.bb.mapper.role.RoleMapper;
import com.ty.bb.service.role.RoleService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@CacheConfig(cacheNames = "role")
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleConverter roleConverter;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<RoleDO> listRole(RoleQuery roleQuery) {
        List<RoleDO> roleList = roleMapper.listRole(roleQuery);
        return roleList;
    }

    @Override
    public RoleDTO queryRole(RoleQuery roleQuery) {
        Example example = new Example(RoleDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("role_code", roleQuery.getRole_code());
        RoleDO roleDO = roleMapper.selectByExample(example).get(0);
        return roleConverter.toDTO(roleDO);
    }

    @Override
    public RoleDTO queryRoleByRoleCode(RoleQuery roleQuery) {
        RoleDO roleDO = roleMapper.queryRoleByCode(roleQuery);
        return roleConverter.toDTO(roleDO);
    }

    @Override
    public void updateRoleCode(RoleDTO roleDTO) {
        roleMapper.updateByPrimaryKey(roleConverter.toDO(roleDTO));
    }

}
