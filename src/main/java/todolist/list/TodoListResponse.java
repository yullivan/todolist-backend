package todolist.list;

public record TodoListResponse(
        Long listId,
        String title,
        int numOfTasks
) {
}
