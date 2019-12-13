package com.ty.bb.controller.role;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.bb.bean.result.Result;
import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import com.ty.bb.bean.role.RoleQuery;
import com.ty.bb.converter.role.RoleConverter;
import com.ty.bb.service.role.RoleService;
import com.ty.bb.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleConverter roleConverter;

    @GetMapping("/listRole")
    public Result<Page<RoleDTO>> listRole(RoleQuery roleQuery) {
        PageHelper.startPage(0, 10);
        roleQuery.setCompany_id("9999");
        List<RoleDO> roleDOList = roleService.listRole(roleQuery);
        return ResultUtil.success(roleConverter.toDTOPage(roleDOList));
    }

    @GetMapping("/queryRole")
    public Result<RoleDTO> queryRole(RoleQuery roleQuery) {
        roleQuery.setRole_code("789789");
        RoleDTO roleDTO = roleService.queryRole(roleQuery);
        return ResultUtil.success(roleDTO);
    }

    @GetMapping("/queryRoleCode")
    public Result<RoleDTO> queryRoleCode(RoleQuery roleQuery) {
        roleQuery.setCompany_id("9999");
        roleQuery.setRole_code("789789");
        RoleDTO roleDTO = roleService.queryRoleByRoleCode(roleQuery);
        return ResultUtil.success(roleDTO);
    }

    @GetMapping("/updateRoleCode")
    public Result updateRoleCode(RoleDTO roleDTO) {
        roleDTO.setCompany_id("9999");
        roleDTO.setRole_code("789789");
        roleDTO.setRole_name("6879789");
        roleService.updateRoleCode(roleDTO);
        return ResultUtil.success();
    }

}
