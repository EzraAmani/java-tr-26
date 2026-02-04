package Excercises.javase015.Linkedlists;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        System.out.println("=== Task Management System with LinkedList ===\n");

        // 1. Adding tasks normally (List behavior)
        System.out.println("1. Adding regular tasks:");
        manager.addTask(new Task(1, "Buy groceries", 2));
        manager.addTask(new Task(2, "Finish report", 2));
        manager.addTask(new Task(3, "Call dentist", 3));

        // Display
        manager.displayTasks();

        // 2. Add high-priority task to front (LinkedList-specific)
        System.out.println("2. Adding high-priority task to FRONT:");
        manager.addHighPriorityTask(new Task(4, "URGENT: Fix bug", 1));

        manager.displayTasks();

        // 3. Queue operations
        System.out.println("3. Queue Operations:");

        // Peek at next task
        System.out.print("Peek: ");
        manager.peekNextTask();

        // Get next task without removing
        Task next = manager.getNextTask();
        if (next != null) {
            System.out.println("Next task to do: " + next);
        }

        // 4. Process tasks (Queue behavior)
        System.out.println("\n4. Processing tasks (FIFO):");
        manager.processNextTask(); // Removes and processes first task
        manager.displayTasks();

        // 5. Complete a task
        System.out.println("5. Completing task ID 2:");
        manager.completeTask(2);
        manager.displayTasks();

        // 6. LinkedList positional operations
        System.out.println("6. LinkedList Positional Operations:");

        // Get task at specific position
        manager.getTaskAtPosition(1);

        // Remove task at position
        System.out.println("\nRemoving task at position 2:");
        manager.removeTaskAtPosition(2);
        manager.displayTasks();

        // 7. Add more tasks
        System.out.println("7. Adding more tasks:");
        manager.addTask(new Task(5, "Plan vacation", 3));
        manager.addHighPriorityTask(new Task(6, "EMERGENCY: Server down", 1));

        manager.displayTasks();

        // 8. Demonstrate all tasks completed
        System.out.println("8. Marking all tasks as completed:");
        for (Task task : manager.getAllTasks()) {
            task.markCompleted();
        }

        // Try to get next task
        Task none = manager.getNextTask();
        if (none == null) {
            System.out.println("Correctly identified all tasks are completed.");
        }

        // 9. Clear all tasks
        System.out.println("\n9. Clearing all tasks:");
        manager.getAllTasks().clear();
        manager.displayTasks();

        // 10. Demonstrate LinkedList as Deque (Double-ended Queue)
        System.out.println("10. LinkedList as Deque (Double-ended Queue):");
        LinkedList<Task> deque = manager.getAllTasks();

        // Add to both ends
        deque.addFirst(new Task(7, "Front task", 1));
        deque.addLast(new Task(8, "Back task", 3));
        deque.addFirst(new Task(9, "Another front task", 1));

        manager.displayTasks();

        // Remove from both ends
        System.out.println("Removing from front and back:");
        Task front = deque.pollFirst();
        Task back = deque.pollLast();
        System.out.println("Removed from front: " + front);
        System.out.println("Removed from back: " + back);

        manager.displayTasks();
    }
}
