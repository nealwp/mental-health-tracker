import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainTest {

    private final MentalHealthTracker tracker = new MentalHealthTracker();

    @Test
    public void tracker_shouldGreetTheUser() {
        assertEquals("hello, how are you feeling today?", tracker.sayHello());
    }

    @Test
    public void tracker_shouldAskForMoodRating() {
        assertEquals("On a scale of 1 to 10, how would you rate your mood today?",
                tracker.askUserForMoodRating());
    }

    @Test
    void tracker_shouldCollectMoodRatingFromUser() {
        assertEquals(5, tracker.mood);
    }
}
