package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;

import java.util.Optional;
import java.util.UUID;

public class TestCachingFindTaskByIdDecorator extends CachingFindTaskByIdDecorator {

    Task cachedTask;

    public TestCachingFindTaskByIdDecorator(FindTaskByIdSpi delegate) {
        super(delegate);
    }

    @Override
    Optional<Task> retrieveFromCache(UUID id) {
        return Optional.ofNullable(cachedTask);
    }

    @Override
    void storeInCache(Task task) {
        cachedTask = task;
    }
}
