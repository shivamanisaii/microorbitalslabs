import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private String department;

    public Student(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Department: " + department;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Student Management System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close(); // Close the scanner when it's no longer needed
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student department: ");
        String department = scanner.next();

        Student student = new Student(name, id, department);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Enter new details:");
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Department: ");
                String department = scanner.next();

                student.setName(name);
                student.setDepartment(department);
                System.out.println("Student details updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students records available.");
            return;
        }

        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
