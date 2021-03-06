package one.digitalivonation.personaapi.dto.request;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;
import one.digitalivonation.personaapi.enums.PhoneType;

@Builder
@Data
public class PhoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;
	
	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

	

}
