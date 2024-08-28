package net.dmfe.archsandbox.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FindTaskByIdSpiMappingSqlQueryTest {

    @Spy
    private FindTaskByIdSpiMappingSqlQuery adapter;

    @Test
    void findTaskById_CallsFindObjectByNamedParam_ReturnsOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        doReturn(task).when(adapter).findObjectByNamedParam(Map.of("id", id));

        // when
        var optional = adapter.findTaskById(id);

        // then
        assertEquals(Optional.of(task), optional);
    }

}
