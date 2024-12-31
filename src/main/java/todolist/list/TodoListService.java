package todolist.list;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.task.Task;
import todolist.task.TaskRepository;
import todolist.task.TaskResponse;

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

    public TodoListDetailResponse findById(Long listId) {
        TodoList todoList = todoListRepository.findById(listId)
                .orElseThrow();
        List<Task> tasks = taskRepository.findByTodoList(todoList);
        return new TodoListDetailResponse(
                todoList.getId(),
                todoList.getTitle(),
                tasks.stream()
                        .map(task -> new TaskResponse(
                                task.getId(),
                                task.getTitle(),
                                task.isCompleted()))
                        .toList()
        );
    }

    @Transactional
    public void deleteById(Long listId) {
        TodoList todoList = todoListRepository.findById(listId)
                .orElseThrow();
//        List<Task> tasks = taskRepository.findByTodoList(todoList);
//        for (Task task : tasks) {
//            taskRepository.deleteById(task.getId());
//        }
        taskRepository.deleteAllByTodoList(todoList);
        todoListRepository.delete(todoList);

    }
}
