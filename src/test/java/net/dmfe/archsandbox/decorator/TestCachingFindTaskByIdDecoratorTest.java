package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestCachingFindTaskByIdDecoratorTest {

    @Mock
    private FindTaskByIdSpi delegate;

    @InjectMocks
    private TestCachingFindTaskByIdDecorator testCachingFindTaskByIdDecorator;

    @Test
    void findTaskById_TaskCached_ReturnsNonEmptyOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        testCachingFindTaskByIdDecorator.cachedTask = task;

        // when
        var result = testCachingFindTaskByIdDecorator.findTaskById(id);

        // then
        assertEquals(Optional.of(task), result);
        verify(delegate, never()).findTaskById(id);
    }
}
