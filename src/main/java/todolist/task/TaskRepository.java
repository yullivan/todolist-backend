package todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;
import todolist.list.TodoList;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // JPA Query Method
    List<Task> findByIsCompleted(boolean isCompleted);

    // TodoList별 전체 Task 개수
    int countByTodoList(TodoList todoList);

    List<Task> findByTodoList(TodoList todoList);

    void deleteAllByTodoList(TodoList todoList);

    // 제목에 특정 문자열이 포함된 task 검색
    List<Task> findByTitleContaining(String keyword);
}
