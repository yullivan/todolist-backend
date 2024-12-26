package todolist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController {

    TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    void create(@RequestBody CreateTaskRequest request) {
        taskService.create(request);
    }

    // 여러 개의 할 일 조회
    @GetMapping("/tasks")
    List<TaskResponse> read() {
        return taskService.findAll();
    }

    @PutMapping("/tasks/{id}")
    void update(@PathVariable Long id, @RequestBody UpdateTaskRequest request) {
        taskService.update(id, request);
    }

    @DeleteMapping("/tasks/{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
