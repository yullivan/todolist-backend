package todolist.task;

public record CreateTaskRequest(
        String title,
        Long listId
) {
}
