
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input data
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            studentList.add(new Student(name, grade));
        }

        // Calculate average, max, and min
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : studentList) {
            sum += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }
            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }

        double average = (double) sum / numStudents;

        // Summary report
        System.out.println("\n--- Summary Report ---");
        for (Student s : studentList) {
            System.out.println(s.name + " - Grade: " + s.grade);
        }

        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (" + lowStudent + ")");
    }
}
