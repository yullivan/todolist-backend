package todolist.task;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void create(CreateTaskRequest request) {
        taskRepository.save(new Task(request.title()));
    }

    public List<TaskResponse> findAll() {
        return taskRepository.findAll()
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
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(request.title());
    }

    @Transactional
    public void flip(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.flip();
    }
}
