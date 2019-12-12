package com.ty.bb.controller.person;

import com.ty.bb.bean.person.PersonDO;
import com.ty.bb.bean.person.PersonDTO;
import com.ty.bb.bean.result.Result;
import com.ty.bb.converter.person.PersonConverter;
import com.ty.bb.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Value("${bb.name}")
    private String name;
    @Autowired
    private PersonConverter personConverter;

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public Result<PersonDTO> getPersonDO() {
        PersonDO personDO = new PersonDO();
        personDO.setAge(23);
        personDO.setName("VV");
        PersonDTO personDTO = personConverter.toDTO(personDO);
        return ResultUtil.success(personDTO);
    }

    @RequestMapping("/")
    public Result<String> sayHello(String name) {
        // 注意是哪个name 参数还是属性
        return ResultUtil.success("Hello " + this.name);
    }
}
