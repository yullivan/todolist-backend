package todolist.task;

import jakarta.persistence.*;
import todolist.list.TodoList;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean isCompleted = false;

    @ManyToOne
    private TodoList todoList;

    protected Task() {
    }

    public Task(String title, TodoList todoList) {
        this.title = title;
        this.todoList = todoList;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void flip() {
        this.isCompleted = !this.isCompleted;
    }
}
