package todolist.task;

public record TaskResponse(
        Long id,
        String title,
        boolean isCompleted) {
}
