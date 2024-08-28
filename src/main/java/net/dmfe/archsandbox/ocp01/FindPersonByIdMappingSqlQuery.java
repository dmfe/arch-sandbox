package net.dmfe.archsandbox.ocp01;

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

public class FindPersonByIdMappingSqlQuery extends MappingSqlQuery<Person> {

    public FindPersonByIdMappingSqlQuery(DataSource ds) {
        super(ds, "select * from app_users_tab where id = :personId");
        declareParameter(new SqlParameter("personId", Types.VARCHAR));
        compile();
    }

    public Optional<Person> findPersonById(PersonId personId) {
        return Optional.ofNullable(findObjectByNamedParam(Map.of("personId", personId.id())));
    }

    @Override
    protected Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Person(new PersonId(rs.getObject("id", UUID.class)), rs.getString("name"));
    }

}
