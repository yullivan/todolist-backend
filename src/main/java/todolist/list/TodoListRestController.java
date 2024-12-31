package todolist.list;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoListRestController {

    private final TodoListService todoListService;

    public TodoListRestController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    // 리스트 생성
    @PostMapping("/lists")
    void create(@RequestBody CreateListRequest request) {
        todoListService.create(request);
    }

    // 리스트 목록 조회
    @GetMapping("/lists")
    List<TodoListResponse> findAll() {
        return todoListService.findAll();
    }
    
    // 리스트 상세 조회
    @GetMapping("/lists/{listId}")
    TodoListDetailResponse findById(@PathVariable Long listId) {
        return todoListService.findById(listId);
    }

    @DeleteMapping("/lists/{listId}")
    public void deleteById(@PathVariable Long listId) {
        todoListService.deleteById(listId);
    }
}
