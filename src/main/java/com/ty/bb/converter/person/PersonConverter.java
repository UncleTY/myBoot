package com.ty.bb.converter.person;

import com.ty.bb.bean.person.PersonDO;
import com.ty.bb.bean.person.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonConverter {
    PersonDO toDO(PersonDTO personDTO);

    PersonDTO toDTO(PersonDO personDO);
}
