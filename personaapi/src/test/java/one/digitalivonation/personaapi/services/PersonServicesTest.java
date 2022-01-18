package one.digitalivonation.personaapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import one.digitalivonation.personaapi.dto.mapper.PersonMapper;
import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.dto.response.MessageResponseDTO;
import one.digitalivonation.personaapi.entities.Person;
import one.digitalivonation.personaapi.reposity.PersonRepository;
import one.digitalivonation.personaapi.service.PersonService;
import one.digitalivonation.personaapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@Mock 
	private PersonMapper personMapper;

	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSuccessSavedMessage() {
		
		PersonDTO personDTO = PersonUtils.createFakeDTO();
		Person expectedSavedPerson = PersonUtils.createFakeEntity();
		
		when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
		when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.getId());
		MessageResponseDTO successMessage = personService.createPerson(personDTO);
		
		assertEquals(expectedSuccessMessage, successMessage);
		
	}
	
	private MessageResponseDTO createExpectedSuccessMessage (Long savedPersonId) {
		
		 return MessageResponseDTO
				 .builder()
				 .message(" return MessageResponseDTO"+ savedPersonId)
				 .build();
		
	}

	
	
}
