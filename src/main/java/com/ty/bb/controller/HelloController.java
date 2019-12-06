package com.ty.bb.controller;

import com.ty.bb.bean.PersonDO;
import com.ty.bb.bean.PersonDTO;
import com.ty.bb.converter.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${bb.name}")
    private String name;
    @Autowired
    private PersonConverter personConverter;

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public PersonDO getPersonDO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(23);
        personDTO.setName("VV");
        PersonDO personDO = personConverter.toDO(personDTO);
        return personDO;
    }

    @RequestMapping("/")
    public String sayHello(String name) {
        // 注意是哪个name 参数还是属性
        return "Hello " + this.name;
    }
}
