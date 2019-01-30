package com.ty.bb.service;

import com.ty.bb.bean.Role;
import com.ty.bb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = "role")
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;


    public List<Role> listRole() {
        return roleRepository.selectAll();
    }
}
