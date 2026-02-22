package Excercises.javase022.filemanagementutility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    // Scanner for user input - made static so all methods can use it
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== SIMPLE FILE MANAGEMENT UTILITY =====");

        // Keep running until user chooses to exit
        while (true) {
            // Display menu options
            System.out.println("\n--- MENU ---");
            System.out.println("1. Create a file");
            System.out.println("2. Create a directory");
            System.out.println("3. List files in a directory");
            System.out.println("4. Check file properties");
            System.out.println("5. Rename a file/directory");
            System.out.println("6. Delete a file/directory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Handle user's choice
            switch (choice) {
                case 1:
                    createFile();
                    break;
                case 2:
                    createDirectory();
                    break;
                case 3:
                    listFiles();
                    break;
                case 4:
                    checkProperties();
                    break;
                case 5:
                    renameFile();
                    break;
                case 6:
                    deleteFile();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please enter 1-7.");
            }
        }
    }

    // Method to create a new file
    public static void createFile() {
        System.out.println("\n--- CREATE FILE ---");
        System.out.print("Enter file path (e.g., C:\\test\\myfile.txt): ");
        String path = scanner.nextLine();

        // Create File object
        File file = new File(path);

        try {
            // Check if file already exists
            if (file.exists()) {
                System.out.println("File already exists!");
                return;
            }

            // Check if parent directory exists, if not create it
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                System.out.println("Parent directory doesn't exist. Creating it...");
                parentDir.mkdirs(); // Create all missing parent directories
            }

            // Create the file
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created successfully: " + file.getAbsolutePath());
                System.out.println("File size: " + file.length() + " bytes");
            } else {
                System.out.println("Failed to create file!");
            }

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot create file");
        }
    }

    // Method to create a new directory
    public static void createDirectory() {
        System.out.println("\n--- CREATE DIRECTORY ---");
        System.out.print("Enter directory path (e.g., C:\\test\\myfolder): ");
        String path = scanner.nextLine();

        // Create File object for directory
        File dir = new File(path);

        try {
            // Check if directory already exists
            if (dir.exists()) {
                System.out.println("Directory already exists!");
                return;
            }

            // Create the directory (and any missing parent directories)
            boolean created = dir.mkdirs(); // mkdirs() creates all missing parent directories
            if (created) {
                System.out.println("Directory created successfully: " + dir.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory!");
            }

        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot create directory");
        }
    }

    // Method to list files in a directory with filters
    public static void listFiles() {
        System.out.println("\n--- LIST FILES ---");
        System.out.print("Enter directory path to list: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        // Check if path exists and is a directory
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("Path is not a directory!");
            return;
        }

        try {
            // Get all files and directories
            File[] allFiles = dir.listFiles();

            if (allFiles == null || allFiles.length == 0) {
                System.out.println("Directory is empty!");
                return;
            }

            System.out.println("\nChoose filter:");
            System.out.println("1. Show all files and directories");
            System.out.println("2. Show only files");
            System.out.println("3. Show only directories");
            System.out.println("4. Show files with specific extension (e.g., .txt)");
            System.out.print("Enter choice (1-4): ");

            int filterChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            File[] filteredFiles = null;

            // Apply different filters based on user choice
            switch (filterChoice) {
                case 1: // All files and directories
                    filteredFiles = allFiles;
                    System.out.println("\n--- ALL ITEMS ---");
                    break;

                case 2: // Only files
                    filteredFiles = dir.listFiles(file -> file.isFile());
                    System.out.println("\n--- ONLY FILES ---");
                    break;

                case 3: // Only directories
                    filteredFiles = dir.listFiles(file -> file.isDirectory());
                    System.out.println("\n--- ONLY DIRECTORIES ---");
                    break;

                case 4: // Files with specific extension
                    System.out.print("Enter extension (e.g., .txt, .java): ");
                    String ext = scanner.nextLine();

                    // Filter files by extension (case insensitive)
                    filteredFiles = dir.listFiles(
                            file -> file.isFile() && file.getName().toLowerCase().endsWith(ext.toLowerCase()));
                    System.out.println("\n--- " + ext.toUpperCase() + " FILES ---");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            // Display filtered results
            if (filteredFiles == null || filteredFiles.length == 0) {
                System.out.println("No items match the filter!");
                return;
            }

            // Create a date formatter for last modified date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Display each file/directory with details
            System.out.println("Name (Type) | Size | Last Modified");
            System.out.println("----------------------------------------");

            for (File f : filteredFiles) {
                String type = f.isDirectory() ? "DIR" : "FILE";
                String size = f.isFile() ? f.length() + " bytes" : "<DIR>";
                String lastModified = sdf.format(f.lastModified());

                System.out.printf("%-20s | %-10s | %s\n",
                        f.getName() + " (" + type + ")", size, lastModified);
            }

            System.out.println("Total items: " + filteredFiles.length);

        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot list directory");
        }
    }

    // Method to check file/directory properties
    public static void checkProperties() {
        System.out.println("\n--- CHECK PROPERTIES ---");
        System.out.print("Enter file/directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        // Check if file/directory exists
        if (!file.exists()) {
            System.out.println("File/Directory does not exist!");
            return;
        }

        try {
            // Display all properties
            System.out.println("\n=== PROPERTIES ===");
            System.out.println("Name: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Parent Directory: " + file.getParent());

            // Type and size
            if (file.isDirectory()) {
                System.out.println("Type: Directory");
                // Count items inside directory
                File[] contents = file.listFiles();
                int itemCount = (contents != null) ? contents.length : 0;
                System.out.println("Contains: " + itemCount + " items");
            } else {
                System.out.println("Type: File");
                System.out.println("Size: " + file.length() + " bytes");
                // Convert to KB/MB for readability
                if (file.length() > 1024) {
                    System.out.println("      " + (file.length() / 1024) + " KB");
                }
                if (file.length() > 1024 * 1024) {
                    System.out.println("      " + (file.length() / (1024 * 1024)) + " MB");
                }
            }

            // Permissions
            System.out.println("\n--- Permissions ---");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Executable: " + file.canExecute());
            System.out.println("Hidden: " + file.isHidden());

            // Time information
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("\n--- Time Information ---");
            System.out.println("Last Modified: " + sdf.format(file.lastModified()));

        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot access properties");
        }
    }

    // Method to rename a file or directory
    public static void renameFile() {
        System.out.println("\n--- RENAME ---");
        System.out.print("Enter current path: ");
        String oldPath = scanner.nextLine();

        File oldFile = new File(oldPath);

        // Check if file/directory exists
        if (!oldFile.exists()) {
            System.out.println("File/Directory does not exist!");
            return;
        }

        System.out.print("Enter new path/name: ");
        String newPath = scanner.nextLine();

        File newFile = new File(newPath);

        try {
            // Check if new name already exists
            if (newFile.exists()) {
                System.out.println("A file/directory with new name already exists!");
                return;
            }

            // Perform rename operation
            boolean renamed = oldFile.renameTo(newFile);

            if (renamed) {
                System.out.println("Renamed successfully!");
                System.out.println("Old: " + oldFile.getName());
                System.out.println("New: " + newFile.getName());
            } else {
                System.out.println("Rename failed! Possible reasons:");
                System.out.println("- New path is on different drive");
                System.out.println("- Permission denied");
                System.out.println("- File is in use");
            }

        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot rename");
        }
    }

    // Method to delete a file or directory
    public static void deleteFile() {
        System.out.println("\n--- DELETE ---");
        System.out.print("Enter path to delete: ");
        String path = scanner.nextLine();

        File file = new File(path);

        // Check if file/directory exists
        if (!file.exists()) {
            System.out.println("File/Directory does not exist!");
            return;
        }

        // Show what we're about to delete
        System.out.println("\nYou are about to delete:");
        System.out.println("Name: " + file.getName());
        System.out.println("Type: " + (file.isDirectory() ? "Directory" : "File"));
        System.out.println("Path: " + file.getAbsolutePath());

        System.out.print("\nAre you sure? (yes/no): ");
        String confirm = scanner.nextLine().toLowerCase();

        if (!confirm.equals("yes")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        try {
            boolean deleted = false;

            if (file.isDirectory()) {
                // For directory, check if it's empty
                File[] contents = file.listFiles();
                if (contents != null && contents.length > 0) {
                    System.out.println("Directory is not empty! Delete all contents? (yes/no): ");
                    String deleteContents = scanner.nextLine().toLowerCase();

                    if (deleteContents.equals("yes")) {
                        // Delete all contents first
                        deleteDirectoryRecursively(file);
                        deleted = true; // deleteDirectoryRecursively deletes the main dir
                    } else {
                        System.out.println("Deletion cancelled.");
                        return;
                    }
                } else {
                    // Empty directory, can delete directly
                    deleted = file.delete();
                }
            } else {
                // For file, delete directly
                deleted = file.delete();
            }

            if (deleted) {
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("Delete failed! File might be in use or permission denied.");
            }

        } catch (SecurityException e) {
            System.out.println("Permission denied: Cannot delete");
        }
    }

    // Helper method to delete directory and all its contents recursively
    private static void deleteDirectoryRecursively(File dir) {
        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                // Recursively delete each file/subdirectory
                deleteDirectoryRecursively(file);
            }
        }
        // Delete the directory itself (now empty)
        dir.delete();
        System.out.println("Deleted: " + dir.getAbsolutePath());
    }
}