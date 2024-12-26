package todolist.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoListRestController {

    private final TodoListService todoListService;

    public TodoListRestController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping("/lists")
    void create(@RequestBody CreateListRequest request) {
        todoListService.create(request);
    }

    @GetMapping("/lists")
    List<TodoListResponse> read() {
        return todoListService.findAll();
    }
}
