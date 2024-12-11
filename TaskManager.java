import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1. Show tasks.");
                System.out.println("2. Add task.");
                System.out.println("3. Edit task.");
                System.out.println("4. Delete task.");
                System.out.println("5. Mark as completed.");
                System.out.println("6. Exit.");
                System.out.print("Enter your choice (1-6): ");

                int choice = input.nextInt();
                input.nextLine();  

                switch (choice) {
                    case 1 -> showTask();
                    case 2 -> addTask();
                    case 3 -> editTask();
                    case 4 -> deleteTask();
                    case 5 -> markAsCompleted();
                    case 6 -> {
                        System.out.println("Exiting... Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    private static void showTask() {
        if(tasks.isEmpty()){
            System.out.println("There are no tasks added.");
            return;
        }

        System.out.println("The list of tasks are: ");
        System.out.println(" ");

        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = input.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    private static void editTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to edit.");
            return;
        }

        displayTasks();
        System.out.print("Enter the task number to edit: ");
        int taskNumber = input.nextInt();
        input.nextLine(); 

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        System.out.print("Enter the new description for task " + taskNumber + ": ");
        String newTask = input.nextLine();
        tasks.set(taskNumber - 1, newTask);
        System.out.println("Task updated.");
    }

    private static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        displayTasks();
        System.out.print("Enter the number of the task you want to delete: ");
        int taskNumber = input.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted.");
    }

    private static void markAsCompleted() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark as completed.");
            return;
        }

        displayTasks();
        System.out.print("Enter the task number to mark as completed: ");
        int taskNumber = input.nextInt();

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        String task = tasks.get(taskNumber - 1);
        tasks.set(taskNumber - 1, task + " (Completed)");
        System.out.println("Task marked as completed.");
    }

    private static void displayTasks() {
        System.out.println("\nCurrent Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
