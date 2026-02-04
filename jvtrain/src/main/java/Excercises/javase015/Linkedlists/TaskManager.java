package Excercises.javase015.Linkedlists;

import java.util.LinkedList;

class TaskManager {
    private LinkedList<Task> tasks;

    public TaskManager() {
        tasks = new LinkedList<>();
    }

    // 1. Add task to the end (as List)
    public void addTask(Task task) {
        tasks.add(task); // addLast() equivalent
        System.out.println("Added: " + task);
    }

    // 2. Add high-priority task to the front
    public void addHighPriorityTask(Task task) {
        tasks.addFirst(task); // LinkedList-specific!
        System.out.println("Added to front (high priority): " + task);
    }

    // 3. Mark task as completed by ID
    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id && !task.isCompleted()) {
                task.markCompleted();
                System.out.println("Completed: " + task);
                return;
            }
        }
        System.out.println("Task ID " + id + " not found or already completed.");
    }

    // 4. Get next task (Queue behavior - FIFO)
    public Task getNextTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the queue.");
            return null;
        }

        // Find first incomplete task
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                return task;
            }
        }
        System.out.println("All tasks are completed!");
        return null;
    }

    // 5. Remove and get next task (like poll())
    public Task processNextTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to process.");
            return null;
        }

        Task nextTask = tasks.poll(); // LinkedList-specific! Removes first element
        if (nextTask != null) {
            System.out.println("Processing: " + nextTask);
        }
        return nextTask;
    }

    // 6. Peek at first task without removing
    public Task peekNextTask() {
        Task firstTask = tasks.peek(); // LinkedList-specific!
        if (firstTask != null) {
            System.out.println("Next up: " + firstTask);
        }
        return firstTask;
    }

    // 7. Display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("\n=== All Tasks ===");
        int position = 1;
        for (Task task : tasks) {
            System.out.println(position + ". " + task);
            position++;
        }
        System.out.println("Total: " + tasks.size() + " tasks\n");
    }

    // 8. Get task by position (LinkedList advantage for positional access)
    public Task getTaskAtPosition(int position) {
        if (position >= 0 && position < tasks.size()) {
            Task task = tasks.get(position); // O(n) for LinkedList
            System.out.println("Task at position " + position + ": " + task);
            return task;
        }
        System.out.println("Invalid position: " + position);
        return null;
    }

    // 9. Remove task by position
    public void removeTaskAtPosition(int position) {
        if (position >= 0 && position < tasks.size()) {
            Task removed = tasks.remove(position); // LinkedList-specific
            System.out.println("Removed from position " + position + ": " + removed);
        } else {
            System.out.println("Invalid position: " + position);
        }
    }

    // 10. Check if list is empty
    public boolean hasTasks() {
        return !tasks.isEmpty();
    }

    // 11. Get all tasks (for demonstration)
    public LinkedList<Task> getAllTasks() {
        return tasks;
    }
}