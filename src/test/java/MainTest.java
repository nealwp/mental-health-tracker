import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void tracker_shouldGreetTheUser() {
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(System.in));
        assertEquals("hello, it's time for your check-in :)", tracker.sayHello());
    }

    @Test
    void tracker_shouldCollectMoodRatingFromUser() {
        String moodRatingInput = "5";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(moodRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForMoodRating();
        assertEquals(5, tracker.mood);
    }

    @Test
    void tracker_shouldWaitForValidMoodRating() {
        String moodRatingInput = "11\n-3\n6"; // first two inputs are invalid, third is valid
        ByteArrayInputStream inputStream = new ByteArrayInputStream(moodRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForMoodRating();
        assertEquals(6, tracker.mood);
    }

    @Test
    void tracker_shouldCollectStressRatingFromUser() {
        String stressRatingInput = "7";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stressRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForStressRating();
        assertEquals(7, tracker.stress);
    }

    @Test
    void tracker_shouldWaitForValidStressRating() {
        String stressRatingInput = "11\n-3\n7"; // first two inputs are invalid, third is valid
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stressRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForStressRating();
        assertEquals(7, tracker.stress);
    }
}
