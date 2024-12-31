package todolist.list;

import org.springframework.stereotype.Service;
import todolist.task.TaskRepository;

import java.util.List;

@Service
public class TodoListService {

    private final TodoListRepository todoListRepository;
    private final TaskRepository taskRepository;

    public TodoListService(TodoListRepository todoListRepository, TaskRepository taskRepository) {
        this.todoListRepository = todoListRepository;
        this.taskRepository = taskRepository;
    }

    public void create(CreateListRequest request) {
        todoListRepository.save(new TodoList(request.title()));
    }

    public List<TodoListResponse> findAll() {
        return todoListRepository.findAll()
                .stream()
                .map(list -> new TodoListResponse(
                        list.getId(),
                        list.getTitle(),
                        taskRepository.countByTodoList(list)))
                .toList();
    }
}
