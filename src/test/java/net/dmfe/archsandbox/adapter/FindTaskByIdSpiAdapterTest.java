package net.dmfe.archsandbox.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FindTaskByIdSpiAdapterTest {

    @Mock
    private NamedParameterJdbcOperations jdbcOperations;

    @InjectMocks
    private FindTaskByIdSpiAdapter adapter;

    @Test
    void findTaskById_CallsQuery_ReturnsOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        doReturn(List.of(task)).when(jdbcOperations)
                .query("select * from tasks_tab where id = :id",
                        Map.of("id", id), adapter);

        // when
        var optional = adapter.findTaskById(id);

        // then
        assertEquals(Optional.of(task), optional);
    }

}
