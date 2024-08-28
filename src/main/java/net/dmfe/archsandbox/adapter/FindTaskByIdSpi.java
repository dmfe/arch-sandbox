package net.dmfe.archsandbox.adapter;

import java.util.Optional;
import java.util.UUID;

public interface FindTaskByIdSpi {

    Optional<Task> findTaskById(UUID id);

}
