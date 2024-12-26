package todolist;

public record TaskResponse(
        Long id,
        String title,
        boolean isCompleted) {
}
