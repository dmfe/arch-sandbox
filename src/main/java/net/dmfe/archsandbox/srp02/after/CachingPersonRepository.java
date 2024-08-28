package net.dmfe.archsandbox.srp02.after;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;
import org.springframework.cache.Cache;

import java.util.Optional;

public final class CachingPersonRepository implements PersonRepository {

    private final Cache cache;
    private final PersonRepository delegate;

    public CachingPersonRepository(Cache cache, PersonRepository delegate) {
        this.cache = cache;
        this.delegate = delegate;
    }

    @Override
    public Optional<Person> findById(PersonId id) {
        return Optional.ofNullable(cache.get(id, Person.class))
                .or(() -> delegate.findById(id).map(person -> {
                    cache.put(person.id(), person);
                    return person;
                }));
    }
}
