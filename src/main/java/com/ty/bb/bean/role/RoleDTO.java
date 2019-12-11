package com.ty.bb.bean.role;

import com.ty.bb.bean.base.OperatorNo;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDTO implements Serializable, OperatorNo {
    private Integer operatorNo;
    private String company_id;
    private String role_code;
    private String role_name;
    private Integer createOperator;
    private Integer modifyOperator;
    private String remark;
}
