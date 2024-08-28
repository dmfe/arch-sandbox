package net.dmfe.archsandbox.adapter;

import org.springframework.jdbc.object.MappingSqlQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FindTaskByIdSpiMappingSqlQuery extends MappingSqlQuery<Task> implements FindTaskByIdSpi {

    @Override
    public Optional<Task> findTaskById(UUID id) {
        return Optional.ofNullable(findObjectByNamedParam(Map.of("id", id)));
    }

    @Override
    protected Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Task(rs.getObject("id", UUID.class));
    }

}
