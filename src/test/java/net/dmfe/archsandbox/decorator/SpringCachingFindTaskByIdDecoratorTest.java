package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class SpringCachingFindTaskByIdDecoratorTest {

    @Mock
    private FindTaskByIdSpi delegate;
    @Mock
    private Cache cache;

    @InjectMocks
    private SpringCachingFindTaskByIdDecorator decorator;

    @Test
    void findTaskById_TaskCached_ReturnsNonEmptyOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        doReturn(task).when(cache).get(id, Task.class);

        // when
        var result = decorator.findTaskById(id);

        // then
        assertEquals(Optional.of(task), result);
        verifyNoMoreInteractions(cache);
    }

    @Test
    void findTaskById_TaskIsNotCachedButExist_ReturnsNonEmptyOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        doReturn(Optional.of(task)).when(delegate).findTaskById(id);

        // when
        var result = decorator.findTaskById(id);

        // then
        assertEquals(Optional.of(task), result);
        verify(cache).put(id, task);
    }

    @Test
    void findTaskById_TaskDoesNotExist_ReturnsEmptyOptional() {
        // given
        var id = UUID.randomUUID();

        // when
        var result = decorator.findTaskById(id);

        // then
        assertEquals(Optional.empty(), result);
        verify(cache, never()).put(any(), any());
    }

}
