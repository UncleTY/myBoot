package com.ty.bb.repository;

import com.ty.bb.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleRepository extends BaseRepository<Role> {
}
