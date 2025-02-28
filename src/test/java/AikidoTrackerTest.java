import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class AikidoTrackerTest {

    @Test
    void testAddPracticeSession() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession(LocalDate.of(2023, 10, 1), 60);
        assertEquals(60, tracker.checkTotalPracticeTime());
    }

    @Test
    void testCheckGraduationEligibility() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession(LocalDate.of(2023, 1, 1), 60);
        tracker.addPracticeSession(LocalDate.of(2023, 7, 1), 60);
        assertTrue(tracker.checkGraduationEligibility());

        for (int i = 0; i < 100; i++) {
            tracker.addPracticeSession(LocalDate.of(2023, 1, 1).plusDays(i), 60);
        }
        assertTrue(tracker.checkGraduationEligibility());
    }

    @Test
    void testCheckTotalPracticeTime() {
        AikidoTracker tracker = new AikidoTracker();
        tracker.addPracticeSession(LocalDate.of(2023, 10, 1), 60);
        tracker.addPracticeSession(LocalDate.of(2023, 10, 2), 30);
        assertEquals(90, tracker.checkTotalPracticeTime());
    }
}