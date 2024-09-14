package net.dmfe.archsandbox.dip.with_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;

import java.util.Optional;

public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public Optional<Task> findById(TaskId taskId) {
        throw new UnsupportedOperationException();
    }

}
