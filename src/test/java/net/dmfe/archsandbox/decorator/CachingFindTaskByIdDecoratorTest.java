package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
class CachingFindTaskByIdDecoratorTest {

    @Mock
    private FindTaskByIdSpi delegate;

    private CachingFindTaskByIdDecorator decorator;

    @BeforeEach
    void setUp() {
        decorator = mock(CachingFindTaskByIdDecorator.class, withSettings().useConstructor(delegate));
        doCallRealMethod().when(decorator).findTaskById(any());
    }

    @Test
    void findTaskById_TaskIsCached_ReturnsNonEmptyOptional() {
        // given
        var id = UUID.randomUUID();
        var task = new Task(id);
        doReturn(Optional.of(task)).when(decorator).retrieveFromCache(id);

        // when
        var result = decorator.findTaskById(id);

        // then
        assertEquals(Optional.of(task), result);
        verify(delegate, never()).findTaskById(id);
        verify(decorator, never()).storeInCache(any());
    }

}
