package todolist.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.list.TodoList;
import todolist.list.TodoListRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TodoListRepository todoListRepository;

    public TaskService(TaskRepository taskRepository, TodoListRepository todoListRepository) {
        this.taskRepository = taskRepository;
        this.todoListRepository = todoListRepository;
    }

    public void create(CreateTaskRequest request) {
        TodoList todoList = todoListRepository.findById(request.listId())
                .orElse(null);
        if (todoList == null) {
            throw new IllegalArgumentException("리스트가 존재하지 않습니다.");
        }
        // 축약 버전: .orElseThrow(() -> new IllegalArgumentException("리스트가 존재하지 않습니다."));

        taskRepository.save(new Task(request.title(), todoList));
    }

    public List<TaskResponse> findAllByCompleted(Boolean isCompleted) {
        if (isCompleted == null) {
            return taskRepository.findAll()
                    .stream()
                    .map(task -> new TaskResponse(
                            task.getId(),
                            task.getTitle(),
                            task.isCompleted()))
                    .toList();
        }

        return taskRepository.findByIsCompleted(isCompleted)
                .stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.isCompleted()))
                .toList();

    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, UpdateTaskRequest request) {
        TodoList todoList = todoListRepository.findById(request.listId())
                .orElseThrow();
        Task task = taskRepository.findById(id)
                .orElseThrow();
        task.changeTitleAndList(request.title(), todoList);
    }

    @Transactional
    public void flip(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.flip();
    }
}
