package one.digitalivonation.personaapi.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalivonation.personaapi.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
