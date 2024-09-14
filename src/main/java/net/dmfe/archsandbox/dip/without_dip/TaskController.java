package net.dmfe.archsandbox.dip.without_dip;

import net.dmfe.archsandbox.dip.Task;
import net.dmfe.archsandbox.dip.TaskId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private TaskService taskService;

    @GetMapping("{taskId}")
    public ResponseEntity<Task> handleGetTaskById(@PathVariable final TaskId taskId) {
        return ResponseEntity.of(taskService.findById(taskId));
    }
}
