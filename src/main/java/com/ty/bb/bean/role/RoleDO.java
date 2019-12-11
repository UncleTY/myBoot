package com.ty.bb.bean.role;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="bg_trole")
public class RoleDO implements Serializable {
    @Id
    @Column(name="company_id")
    private String company_id;
    @Id
    @Column(name="role_code")
    private String role_code;
    @Column(name="role_name")
    private String role_name;
    @Column(name="remark")
    private String remark;
}
