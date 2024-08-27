package net.dmfe.archsandbox.srp02.before;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;
import org.springframework.cache.Cache;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class PersonRepository implements RowMapper<Person> {

    private JdbcTemplate jdbcTemplate;
    private Cache cache;

    public Optional<Person> findById(PersonId id) {
        return Optional.ofNullable(cache.get(id, Person.class))
                .or(() ->
                        Optional.ofNullable(
                                jdbcTemplate.queryForObject("select * from app_users_tab where id = ?", this, id.id())
                        ).map(person -> {
                            cache.put(person.id(), person);
                            return person;
                        })
                );
    }

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                new PersonId(rs.getObject("id", UUID.class)),
                rs.getString("name")
        );
    }
}
