package one.digitalivonation.personaapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalivonation.personaapi.dto.MessageResponseDTO;
import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.reposity.PersonRepository;
import one.digitalivonation.personaapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonRepository personRepository;
	
	private PersonService personService;
	
	

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		
		return personService.createPerson(personDTO);
		
	}
	
	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

}
