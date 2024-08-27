package net.dmfe.archsandbox.srp02.after;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;

import java.util.Optional;

public interface PersonRepository {

    Optional<Person> findById(PersonId id);

}
