import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

public class MainTest {

    private final MentalHealthTracker tracker = new MentalHealthTracker();

    @Test
    public void tracker_shouldGreetTheUser() {
        assertEquals("hello, it's time for your check-in :)", tracker.sayHello());
    }

    @Test
    void tracker_shouldCollectMoodRatingFromUser() {
        String simulatedInput = "5";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        tracker.askUserForMoodRating();
        assertEquals(5, tracker.mood);
    }

    @Test
    void tracker_shouldWaitForValidMoodRating() {
        String simulatedInput = "11\n-3\n6"; // first two inputs are invalid, third is valid
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        tracker.askUserForMoodRating();
        assertEquals(6, tracker.mood);
    }
}
