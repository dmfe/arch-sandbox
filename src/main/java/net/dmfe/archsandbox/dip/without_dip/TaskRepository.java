package net.dmfe.archsandbox.dip.without_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;

import java.util.Optional;

public class TaskRepository {

    Optional<Task> findById(TaskId taskId) {
        throw new UnsupportedOperationException();
    }
}
