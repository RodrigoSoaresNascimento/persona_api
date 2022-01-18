package one.digitalivonation.personaapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import one.digitalivonation.personaapi.dto.request.PersonDTO;
import one.digitalivonation.personaapi.entities.Person;

public class PersonUtils {
	
	
	private static final String FIRST_NAME = "Rodrigo";
	private static final String LAST_NAME = "Soares";
	private static final String CPF_NUMBER = "000.558.789.45";
	private static final long  PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(2022, 03, 24);
	
	
	public static PersonDTO createFakeDTO() {
		
		return PersonDTO.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate("1997, 03 , 24")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
		
	}
	
	public static Person createFakeEntity() {
		
		return Person
				.builder()
				.name(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}

}
