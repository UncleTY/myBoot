package com.ty.bb.bean.role;

import com.github.pagehelper.page.PageParams;
import com.ty.bb.bean.base.OperatorNo;
import com.ty.bb.bean.base.WritableCreateAndModifyOperator;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleQuery extends PageParams implements OperatorNo, WritableCreateAndModifyOperator {
    private Integer operatorNo;
    private String company_id;
    private String role_code;
    private String role_name;
    private Integer createOperator;
    private Integer modifyOperator;
    private String remark;
}
