package todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // JPA Query Method
    List<Task> findByIsCompleted(boolean isCompleted);
}
