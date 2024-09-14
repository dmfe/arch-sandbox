package net.dmfe.archsandbox.dip.without_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;

import java.util.Optional;

public class TaskService {

    private TaskRepository taskRepository;

    Optional<Task> findById(TaskId taskId) {
        return taskRepository.findById(taskId);
    }
}
