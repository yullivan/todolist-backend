package todolist.task;

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
    List<TaskResponse> findAll(
            @RequestParam(required = false) Boolean isCompleted,
            @RequestParam(required = false) String keyword) {
        return taskService.findAllByCompleted(isCompleted, keyword);
    }

    @PutMapping("/tasks/{id}")
    void update(@PathVariable Long id, @RequestBody UpdateTaskRequest request) {
        taskService.update(id, request);
    }

    @PatchMapping("/tasks/{id}")
    void flip(@PathVariable Long id) {
        taskService.flip(id);
    }

    @DeleteMapping("/tasks/{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
