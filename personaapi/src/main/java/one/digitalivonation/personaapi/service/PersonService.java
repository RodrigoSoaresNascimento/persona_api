package one.digitalivonation.personaapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import one.digitalivonation.personaapi.Person;
import one.digitalivonation.personaapi.dto.MessageResponseDTO;
import one.digitalivonation.personaapi.dto.mapper.PersonMapper;
import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.reposity.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@PostMapping
	public MessageResponseDTO createPerson( PersonDTO personDTO) {
		
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO
				.builder()
				.message("Created person with id " + savedPerson.getId())
				.build();
				
	}

	public List<PersonDTO> listAll() {
		List <Person> allPeople = personRepository.findAll();
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}


}