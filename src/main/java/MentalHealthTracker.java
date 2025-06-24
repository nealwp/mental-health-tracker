import java.io.PrintStream;
import java.util.Scanner;

public class MentalHealthTracker {
    public int mood;
    public int stress;
    public String reflection;
    private PrintStream printer;
    private Scanner scanner;

    public MentalHealthTracker(PrintStream printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        sayHello();
        askUserForMoodRating();
        askUserForStressRating();
        askUserForReflection();
    }

    public void sayHello() {
        printer.println("hello, it's time for your check-in :)");
    }

    public void askUserForMoodRating() {
        while (mood < 1 || mood > 10) {
            printer.print("On a scale of 1 to 10, please rate your mood: ");
            mood = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void askUserForStressRating() {
        while (stress < 1 || stress > 10) {
            printer.print("On a scale of 1 to 10, please rate your stress: ");
            stress = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void askUserForReflection() {
        printer.print("Do you have any particular thoughts today? ");
        String input = scanner.nextLine();
        if (input.length() == 0) {
            reflection = "";
        } else {
            reflection = input;
        }

    }

}
