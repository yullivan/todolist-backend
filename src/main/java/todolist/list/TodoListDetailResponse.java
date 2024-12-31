package todolist.list;

import todolist.task.Task;

import java.util.List;

public record TodoListDetailResponse(
        Long listId,
        String title,
        List<Task> tasks
) {
    record Task(
            Long id,
            String content,
            boolean isCompleted
    ) {
    }
}
