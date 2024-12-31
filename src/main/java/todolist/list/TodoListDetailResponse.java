package todolist.list;

import todolist.task.TaskResponse;

import java.util.List;

public record TodoListDetailResponse(
        Long listId,
        String title,
        List<TaskResponse> tasks
) {
}
