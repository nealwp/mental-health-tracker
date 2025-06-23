import java.io.PrintStream;
import java.util.Scanner;

public class MentalHealthTracker {
    public int mood;
    public int stress;
    private PrintStream printer;
    private Scanner scanner;

    public MentalHealthTracker(PrintStream printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public String sayHello() {
        return "hello, it's time for your check-in :)";
    }

    public void askUserForMoodRating() {
        while (this.mood < 1 || this.mood > 10) {
            this.printer.print("On a scale of 1 to 10, please rate your mood: ");
            this.mood = this.scanner.nextInt();
        }
    }

    public void askUserForStressRating() {
        while (this.stress < 1 || this.stress > 10) {
            this.printer.print("On a scale of 1 to 10, please rate your stress: ");
            this.stress = this.scanner.nextInt();
        }
    }
}
