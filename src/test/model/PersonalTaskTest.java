package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonalTaskTest {
    @Test
    public void testSetTimeRequiredToFinishTaskToZero() {
        PersonalTask p1 = new PersonalTask("A","AA",3);
        p1.setTimeRequiredToFinishTaskToZero();
        assertEquals(0,p1.getTimeRequiredToFinishTask());

    }
}
