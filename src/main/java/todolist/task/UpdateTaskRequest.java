package todolist.task;

public record UpdateTaskRequest(
        String title,
        Long listId
) {
}
