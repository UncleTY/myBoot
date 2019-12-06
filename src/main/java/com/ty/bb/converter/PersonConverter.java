package com.ty.bb.converter;

import com.ty.bb.bean.PersonDO;
import com.ty.bb.bean.PersonDTO;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonConverter {
    PersonDO toDO(PersonDTO personDTO);

    PersonDTO toDTO(PersonDO personDO);
}
