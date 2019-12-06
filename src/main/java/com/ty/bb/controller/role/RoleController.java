package com.ty.bb.controller.role;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ty.bb.bean.role.Role;
import com.ty.bb.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/listRole")
    public Page<Role> listRole() {
        PageHelper.startPage(2, 10);
        Page<Role> page =  (Page<Role>) roleService.listRole();
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("每页记录条数：" + page.getPageSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        return page;
    }

}
