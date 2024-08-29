package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;
import org.springframework.cache.Cache;

import java.util.Optional;
import java.util.UUID;

public class SpringCachingFindTaskByIdDecorator extends CachingFindTaskByIdDecorator {

    private final Cache cache;

    public SpringCachingFindTaskByIdDecorator(FindTaskByIdSpi delegate, Cache cache) {
        super(delegate);
        this.cache = cache;
    }

    @Override
    Optional<Task> retrieveFromCache(UUID id) {
        return Optional.ofNullable(cache.get(id, Task.class));
    }

    @Override
    void storeInCache(Task task) {
        cache.put(task.id(), task);
    }
}
