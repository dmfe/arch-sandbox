package net.dmfe.archsandbox.adapter;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FindTaskByIdSpiAdapter implements FindTaskByIdSpi, RowMapper<Task> {

    private final NamedParameterJdbcOperations jdbcOperations;

    public FindTaskByIdSpiAdapter(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Optional<Task> findTaskById(UUID id) {
        return jdbcOperations.query("select * from tasks_tab where id = :id",
                        Map.of("id", id), this).stream().findFirst();
    }

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Task(rs.getObject("id", UUID.class));
    }

}
