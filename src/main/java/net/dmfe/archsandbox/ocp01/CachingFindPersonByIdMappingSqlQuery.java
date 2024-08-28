package net.dmfe.archsandbox.ocp01;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;
import org.springframework.cache.Cache;

import javax.sql.DataSource;
import java.util.Optional;

public class CachingFindPersonByIdMappingSqlQuery extends FindPersonByIdMappingSqlQuery {

    private final Cache cache;

    public CachingFindPersonByIdMappingSqlQuery(DataSource ds, Cache cache) {
        super(ds);
        this.cache = cache;
    }

    @Override
    public Optional<Person> findPersonById(PersonId personId) {
        return findPersonById(personId, true);
    }

    public Optional<Person> findPersonById(PersonId personId, boolean useCache) {
        if (useCache) {
            return Optional.ofNullable(cache.get(personId, Person.class))
                    .or(() -> super.findPersonById(personId))
                    .map(person -> {
                        cache.put(person.id(), person);
                        return person;
                    });
        } else {
            return super.findPersonById(personId);
        }
    }
}
