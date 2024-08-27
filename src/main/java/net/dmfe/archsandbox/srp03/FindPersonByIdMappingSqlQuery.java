package net.dmfe.archsandbox.srp03;

import net.dmfe.archsandbox.srp02.Person;
import net.dmfe.archsandbox.srp02.PersonId;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FindPersonByIdMappingSqlQuery extends MappingSqlQuery<Person> implements FindPersonByIdSpi {

    public FindPersonByIdMappingSqlQuery(DataSource ds) {
        super(ds, "select * from app_users_tab where id = :personId");
        declareParameter(new SqlParameter("personId", Types.VARCHAR));
        compile();
    }

    @Override
    public Optional<Person> findPersonById(PersonId id) {
        return executeByNamedParam(Map.of("personId", id.id())).stream().findFirst();
    }

    @Override
    protected Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(
                new PersonId(rs.getObject("id", UUID.class)),
                rs.getString("name")
        );
    }
}
