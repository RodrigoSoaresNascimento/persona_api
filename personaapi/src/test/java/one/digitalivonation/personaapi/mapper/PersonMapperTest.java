package one.digitalivonation.personaapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import one.digitalivonation.personaapi.dto.mapper.PersonMapper;
import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.dto.request.PhoneDTO;
import one.digitalivonation.personaapi.entities.Person;
import one.digitalivonation.personaapi.entities.Phone;
import one.digitalivonation.personaapi.utils.PersonUtils;

@SpringBootTest
public class PersonMapperTest {
	
	@Autowired
	private PersonMapper personMapper;
	
	@Test
	void testGivenPersonDTOThenReturnPersonEntity() {
		 
		  PersonDTO personDTO = PersonUtils.createFakeDTO();
		  Person person = personMapper.toModel(personDTO);
		  
		  assertEquals(personDTO.getFirstName(), person.getName());
		  assertEquals(personDTO.getLastName(), person.getLastName());
		  assertEquals(personDTO.getCpf(), person.getCpf());
		  
		  Phone phone = person.getPhones().get(0);
		  PhoneDTO phoneDTO = personDTO.getPhones().get(0);
		  
		  assertEquals(phoneDTO.getType(), phone.getType());
		  assertEquals(phoneDTO.getNumber(), phone.getNumber());
		  

	 }
	@Test
	void testGivenPersonEntityThenReturnPersonDTO() {
		
		Person person = PersonUtils.createFakeEntity();
		PersonDTO personDTO = personMapper.toTDO(person);
		
		assertEquals(person.getName(), personDTO.getFirstName());
		assertEquals(person.getLastName(), personDTO.getLastName());
		assertEquals(person.getCpf(), personDTO.getCpf());
		
		Phone phone = person.getPhones().get(0);
		PhoneDTO phoneDTO = personDTO.getPhones().get(0);
		
		assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
		 
		
	}


}
