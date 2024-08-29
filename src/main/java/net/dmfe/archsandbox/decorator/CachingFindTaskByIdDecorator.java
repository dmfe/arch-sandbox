package net.dmfe.archsandbox.decorator;

import net.dmfe.archsandbox.adapter.FindTaskByIdSpi;
import net.dmfe.archsandbox.adapter.Task;

import java.util.Optional;
import java.util.UUID;

abstract class CachingFindTaskByIdDecorator implements FindTaskByIdSpi {

    private final FindTaskByIdSpi delegate;

    public CachingFindTaskByIdDecorator(FindTaskByIdSpi delegate) {
        this.delegate = delegate;
    }

    abstract Optional<Task> retrieveFromCache(UUID id);

    abstract void storeInCache(Task task);

    @Override
    public Optional<Task> findTaskById(UUID id) {
        return retrieveFromCache(id)
                .or(() -> delegate.findTaskById(id)
                        .map(task -> {
                            storeInCache(task);
                            return task;
                        })
                );
    }
}
