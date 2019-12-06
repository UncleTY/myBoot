package com.ty.bb.bean.role;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoleMember {
    private String company_id;
    private String role_code;
    private String op_code;
    private Timestamp modified_time;
}
