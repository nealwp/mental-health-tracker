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

    // constructor, injecting something to print with and an input scanner
    public MentalHealthTracker(PrintStream printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    // main program procedure
    public void run() {
        // say hello to the user
        sayHello();
        // ask the user for their mood rating
        askUserForMoodRating();
        // ask the user for their stress rating
        askUserForStressRating();
        // ask the user for their reflection
        askUserForReflection();
        // save the entry
        saveEntry();
        // ask if the user wants to see past entries
        boolean userWantsToSeePastEntries = askUserIfTheyWantToSeePastEntries();
        // if they do
        if (userWantsToSeePastEntries) {
            // show past entries
            showPastEntries();
        } else {
            // otherwise, say goodbye
            sayGoodbye();
        }
    }

    // say hello to the user
    public void sayHello() {
        printer.println("hello, it's time for your check-in :)");
    }

    // say goodbye to the user
    public void sayGoodbye() {
        printer.println("goodbye.");
    }

    // ask the user for their mood rating
    public void askUserForMoodRating() {
        // wait for the user to provide a valid rating
        while (mood < 1 || mood > 10) {
            printer.print("On a scale of 1 to 10, please rate your mood: ");
            mood = scanner.nextInt();
            scanner.nextLine();
        }
    }

    // ask the user for their stress rating
    public void askUserForStressRating() {
        // wait for the user to provide a valid rating
        while (stress < 1 || stress > 10) {
            printer.print("On a scale of 1 to 10, please rate your stress: ");
            stress = scanner.nextInt();
            scanner.nextLine();
        }
    }

    // ask the user for their reflection
    public void askUserForReflection() {
        printer.print("Do you have any particular thoughts today? ");
        String input = scanner.nextLine();
        // if input is empty, use an empty string
        if (input.length() == 0) {
            reflection = "";
        } else {
            // otherwise, use the user input
            reflection = input;
        }

    }

    public void saveEntry() {
        // get todays date
        String today = LocalDate.now().toString();
        // format the entry as CSV
        String entry = String.format("%s, %d,%d,%s", today, mood, stress, reflection);

        try {
            // update the csv file with the entry
            Files.write(path, List.of(entry), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            // tell the user it's been saved
            printer.println("Your entry has been saved. Thanks for checking in!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // prompt the user for showing past entries
    public boolean askUserIfTheyWantToSeePastEntries() {
        // start with an empty response
        String response = "";
        // wait for the user to provide valid input
        while (!response.equalsIgnoreCase("n") && !response.equalsIgnoreCase("y")) {
            printer.print("Would you like to see past entries? (y/n): ");
            response = scanner.next();
        }
        // return true/false based on response
        return response.equalsIgnoreCase("y");
    }

    // prints the past entries to the console
    public void showPastEntries() {
        try {
            // read the whole file
            List<String> lines = Files.readAllLines(path);

            // loop through each line
            for (String line : lines) {
                // split up the csv line
                String[] fields = line.split(",", -1);

                // print a formatted output
                System.out.printf("Date: %s; Mood: %s; Stress: %s; Reflection: %s%n",
                        fields[0], fields[1], fields[2], fields[3]);
            }

        } catch (IOException e) {
            System.err.println("Failed to read file: " + e.getMessage());
        }
    }
}
