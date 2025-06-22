import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MainTest {

    private final MentalHealthTracker mentalHealthTracker = new MentalHealthTracker();

    @Test
    public void sayHello_shouldGreetTheUser() {
        assertEquals(mentalHealthTracker.sayHello(), "hello, how are you feeling today?");
    }
}
