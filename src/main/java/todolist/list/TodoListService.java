package todolist.list;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void create(CreateListRequest request) {
        todoListRepository.save(new TodoList(request.title()));
    }

    public List<TodoListResponse> findAll() {
        return todoListRepository.findAll()
                .stream()
                .map(list -> new TodoListResponse(list.getId(), list.getTitle()))
                .toList();
    }
}
