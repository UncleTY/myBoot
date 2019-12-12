package com.ty.bb.controller.role;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.bb.bean.result.Result;
import com.ty.bb.bean.role.RoleDO;
import com.ty.bb.bean.role.RoleDTO;
import com.ty.bb.bean.role.RoleQuery;
import com.ty.bb.service.role.RoleService;
import com.ty.bb.utils.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RoleController {
    @Resource
    private RoleService roleService;

    @GetMapping("/listRole")
    public Result<Page<RoleDO>> listRole(RoleQuery roleQuery) {
        PageHelper.startPage(2, 10);
        Page<RoleDO> page = (Page<RoleDO>) roleService.listRole(roleQuery);
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("每页记录条数：" + page.getPageSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        return ResultUtil.success(page);
    }

    @GetMapping("/queryRole")
    public Result<RoleDTO> queryRole(RoleQuery roleQuery) {
        roleQuery.setRole_code("789789");
        RoleDTO roleDTO = roleService.queryRole(roleQuery);
        return ResultUtil.success(roleDTO);
    }

    @GetMapping("/queryRoleCode")
    public Result<RoleDTO> queryRoleCode(RoleQuery roleQuery) {
        roleQuery.setRole_code("789789");
        RoleDTO roleDTO = roleService.queryRoleByRoleCode(roleQuery);
        return ResultUtil.success(roleDTO);
    }

}
