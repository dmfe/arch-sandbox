package net.dmfe.archsandbox.srp02.after;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public final class JdbcTemplatePersonRepository implements RowMapper<Person>, PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Person> findById(PersonId id) {
        return Optional.ofNullable(jdbcTemplate
                .queryForObject("select * from app_users_tab where id = ?", this, id.id())
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
