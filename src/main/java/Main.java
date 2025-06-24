import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(System.in));
        tracker.run();
    }
}
