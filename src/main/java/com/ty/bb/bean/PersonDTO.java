package com.ty.bb.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDTO implements Serializable {
    private String name;
    private Integer age;

    public PersonDTO() {
    }

    public PersonDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
