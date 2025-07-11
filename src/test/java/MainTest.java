import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void tracker_shouldCollectMoodRatingFromUser() {
        String moodRatingInput = "5\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(moodRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForMoodRating();
        assertEquals(5, tracker.mood);
    }

    @Test
    void tracker_shouldWaitForValidMoodRating() {
        String moodRatingInput = "11\n-3\n6\n"; // first two inputs are invalid, third is valid
        ByteArrayInputStream inputStream = new ByteArrayInputStream(moodRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForMoodRating();
        assertEquals(6, tracker.mood);
    }

    @Test
    void tracker_shouldCollectStressRatingFromUser() {
        String stressRatingInput = "7\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stressRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForStressRating();
        assertEquals(7, tracker.stress);
    }

    @Test
    void tracker_shouldWaitForValidStressRating() {
        String stressRatingInput = "11\n-3\n7\n"; // first two inputs are invalid, third is valid
        ByteArrayInputStream inputStream = new ByteArrayInputStream(stressRatingInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForStressRating();
        assertEquals(7, tracker.stress);
    }

    @Test
    void tracker_shouldCollectReflectionFromUser() {
        String reflectionInput = "i felt alright today.\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(reflectionInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForReflection();
        assertEquals("i felt alright today.", tracker.reflection);
    }

    @Test
    void tracker_shouldAllowEmptyReflection() {
        String reflectionInput = "\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(reflectionInput.getBytes());
        MentalHealthTracker tracker = new MentalHealthTracker(System.out, new Scanner(inputStream));
        tracker.askUserForReflection();
        assertEquals("", tracker.reflection);
    }

}
