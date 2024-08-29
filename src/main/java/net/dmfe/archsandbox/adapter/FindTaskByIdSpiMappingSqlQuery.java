package net.dmfe.archsandbox.adapter;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FindTaskByIdSpiMappingSqlQuery extends MappingSqlQuery<Task> implements FindTaskByIdSpi {

    public FindTaskByIdSpiMappingSqlQuery(DataSource ds) {
        super(ds, "select * from tasks_tab where id = :id");
        declareParameter(new SqlParameter("id", Types.VARCHAR));
        compile();
    }

    @Override
    public Optional<Task> findTaskById(UUID id) {
        return Optional.ofNullable(findObjectByNamedParam(Map.of("id", id)));
    }

    @Override
    protected Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Task(rs.getObject("id", UUID.class));
    }

}
