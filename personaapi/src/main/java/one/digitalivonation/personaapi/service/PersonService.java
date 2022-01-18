package one.digitalivonation.personaapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import one.digitalivonation.personaapi.dto.mapper.PersonMapper;
import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.dto.response.MessageResponseDTO;
import one.digitalivonation.personaapi.entities.Person;
import one.digitalivonation.personaapi.exception.PersonNotFoundException;
import one.digitalivonation.personaapi.reposity.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private static PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	
	@PostMapping
	public MessageResponseDTO createPerson( PersonDTO personDTO) {
		
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return createdMessageResponse( savedPerson.getId() + "Createda a person with id", null);
				
	}

	public List<PersonDTO> listAll() {
		List <Person> people = personRepository.findAll();
		return people.stream()
				.map(personMapper::toTDO)
                .collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {

		 Person person = verifyIfExists(id);
		return personMapper.toTDO(person);
		
	}

	public static void delete(Long id) throws PersonNotFoundException {
		
		 verifyIfExists(id);
		
		personRepository.deleteById(id);
		
		
	}
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		
		verifyIfExists(id);
		
		Person personToSave = personMapper.toModel(personDTO);
		
		Person updatedPerson = personRepository.save(personToSave);
		return createdMessageResponse(updatedPerson.getId() + "Created a person with id", id);
				
	}
	
	private static  Person verifyIfExists(Long id) throws PersonNotFoundException{
		
		return personRepository.findById(id)
				.orElseThrow(()-> new PersonNotFoundException(id));
	}


	private MessageResponseDTO  createdMessageResponse(String message, Long id2) {
		
		return MessageResponseDTO
		.builder()
		.message(message + id2)
		.build();
				
	}



}
