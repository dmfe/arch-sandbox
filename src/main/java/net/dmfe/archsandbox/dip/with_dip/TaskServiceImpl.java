package net.dmfe.archsandbox.dip.with_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;

import java.util.Optional;

public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Override
    public Optional<Task> findById(TaskId taskId) {
        return taskRepository.findById(taskId);
    }

}
