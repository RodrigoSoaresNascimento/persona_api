package one.digitalivonation.personaapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthdate", source = "birthdate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO dto);
	

	PersonDTO toTDO(Person dto);

}
