package com.ty.bb.service.impl.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleQuery;
import com.ty.bb.repository.role.RoleRepository;
import com.ty.bb.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "role")
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDO> listRole(RoleQuery roleQuery) {
        List<RoleDO> roleList = roleRepository.selectAll();
        return roleList;
    }
}
