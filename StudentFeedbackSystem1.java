import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StudentFeedbackSystem {

    static final String FILE_NAME = "feedback.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Feedback System =====");
            System.out.println("1. Submit Feedback");
            System.out.println("2. View All Feedbacks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    submitFeedback(scanner);
                    break;
                case 2:
                    viewFeedback();
                    break;
                case 3:
                    System.out.println("Thank you for using the feedback system.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }

        } while (choice != 3);

        scanner.close();
    }

    private static void submitFeedback(Scanner scanner) {
        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your feedback: ");
            String feedback = scanner.nextLine();

            String data = "Name: " + name + "\nFeedback: " + feedback + "\n--------------------------\n";

            try (FileOutputStream fos = new FileOutputStream(FILE_NAME, true)) {
                fos.write(data.getBytes());
                System.out.println("Feedback submitted successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error writing feedback: " + e.getMessage());
        }
    }

    private static void viewFeedback() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            int ch;
            System.out.println("\n=== All Feedbacks ===");
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Error reading feedback: " + e.getMessage());
        }
    }
}
