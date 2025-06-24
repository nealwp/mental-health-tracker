import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.nio.file.Path;
import java.util.List;

public class MentalHealthTracker {
    public int mood;
    public int stress;
    public String reflection;
    private PrintStream printer;
    private Scanner scanner;
    private Path path = new File("output.csv").toPath();

    public MentalHealthTracker(PrintStream printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        sayHello();
        askUserForMoodRating();
        askUserForStressRating();
        askUserForReflection();
        saveEntry();
        boolean userWantsToSeePastEntries = askUserIfTheyWantToSeePastEntries();
        if (userWantsToSeePastEntries) {
            showPastEntries();
        } else {
            sayGoodbye();
        }
    }

    public void sayHello() {
        printer.println("hello, it's time for your check-in :)");
    }

    public void sayGoodbye() {
        printer.println("goodbye.");
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

    public void saveEntry() {
        String today = LocalDate.now().toString();
        String row = String.format("%s, %d,%d,%s", today, mood, stress, reflection);

        try {
            Files.write(path, List.of(row), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            printer.println("Your entry has been saved. Thanks for checking in!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean askUserIfTheyWantToSeePastEntries() {
        String response = "";
        while (!response.equalsIgnoreCase("n") && !response.equalsIgnoreCase("y")) {
            printer.print("Would you like to see past entries? (y/n): ");
            response = scanner.next();
        }
        return response.equalsIgnoreCase("y");
    }

    public void showPastEntries() {
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                String[] fields = line.split(",", -1);

                System.out.printf("Date: %s; Mood: %d; Stress: %d; Reflection: %s%n",
                        fields[0], fields[1], fields[2], fields[3]);
            }

        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }
}
