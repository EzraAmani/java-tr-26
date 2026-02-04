package Excercises.javase015.Linkedlists;

class Task {
    private int id;
    private String description;
    private int priority; // 1 = highest, 3 = lowest
    private boolean completed;

    public Task(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Setter for completed
    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "✓" : "✗";
        return "Task" + id + ": " + description +
                " [Priority: " + priority + "] " + status;
    }
}