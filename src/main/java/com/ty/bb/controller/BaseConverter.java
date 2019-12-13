package com.ty.bb.controller;

import com.ty.bb.bean.Page;

import java.io.Serializable;
import java.util.List;

public interface BaseConverter<DoT, DtoT extends Serializable> {
    DoT toDO(DtoT var1);

    List<DoT> toDO(Iterable<DtoT> var1);

    DtoT toDTO(DoT var1);

    List<DtoT> toDTO(Iterable<DoT> var1);

    default Page<DtoT> toDTOPage(List<DoT> doBean) {
        Page<DtoT> page = new Page();
        if (doBean != null) {
            if (doBean instanceof com.github.pagehelper.Page) {
                page.setTotal(((com.github.pagehelper.Page) doBean).getTotal());
            } else {
                page.setTotal((long) doBean.size());
            }

            page.setRows(this.toDTO((Iterable) doBean));
        }

        return page;
    }
}
