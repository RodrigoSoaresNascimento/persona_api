package one.digitalivonation.personaapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {
	
	HOME("Home"),
	MOBILE("Mobile"),
	COMMERCIAL("commercial");
	
	private final String description;

}
