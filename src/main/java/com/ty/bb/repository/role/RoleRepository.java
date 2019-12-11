package com.ty.bb.repository.role;

import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.repository.base.BaseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoleRepository extends BaseRepository<RoleDO> {
}
