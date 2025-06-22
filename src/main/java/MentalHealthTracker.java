import java.util.Scanner;

public class MentalHealthTracker {
    public int mood;

    public String sayHello() {
        return "hello, it's time for your check-in :)";
    }

    public void askUserForMoodRating() {
        Scanner input = new Scanner(System.in);
        while (this.mood < 1 || this.mood > 10) {
            System.out.print("On a scale of 1 to 10, please rate your mood: ");
            this.mood = input.nextInt();
        }
        input.close();
    }
}
