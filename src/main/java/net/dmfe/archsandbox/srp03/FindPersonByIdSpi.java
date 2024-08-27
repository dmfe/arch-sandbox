package net.dmfe.archsandbox.srp03;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;

import java.util.Optional;

@FunctionalInterface
public interface FindPersonByIdSpi {

    Optional<Person> findPersonById(PersonId id);

}
