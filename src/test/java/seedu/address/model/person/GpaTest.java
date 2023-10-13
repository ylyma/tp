package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GpaTest {

    @Test
    public void isValidGpa() {
        // invalid GPAs
        assertFalse(Gpa.isValidGpa(-1.0));
        assertFalse(Gpa.isValidGpa(5.1));

        // valid GPAs
        assertTrue(Gpa.isValidGpa(0.0));
        assertTrue(Gpa.isValidGpa(4.0));
        assertTrue(Gpa.isValidGpa(5.0));
    }

    @Test
    public void equals() {
        Gpa gpa = new Gpa(3.2);

        // same values -> returns true
        assertTrue(gpa.equals(new Gpa(3.2)));

        // same object -> returns true
        assertTrue(gpa.equals(gpa));

        // null -> returns false
        assertFalse(gpa.equals(null));

        // different types -> returns false
        assertFalse(gpa.equals("Test"));

        // different values -> returns false
        assertFalse(gpa.equals(new Gpa(3.3)));
    }
}
