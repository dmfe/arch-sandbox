package net.dmfe.archsandbox.dip.with_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;

import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(TaskId taskId);

}
