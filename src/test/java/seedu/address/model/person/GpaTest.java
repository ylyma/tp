package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GpaTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Gpa(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new Gpa(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> Gpa.isValidGpa(null));

        // invalid addresses
        assertFalse(Gpa.isValidGpa("")); // empty string
        assertFalse(Gpa.isValidGpa(" ")); // spaces only

        // valid addresses
        assertTrue(Gpa.isValidGpa("4.0"));
        assertTrue(Gpa.isValidGpa("-")); // one character
        assertTrue(Gpa.isValidGpa("5.0")); // long address
    }

    @Test
    public void equals() {
        Gpa address = new Gpa("Valid GPA");

        // same values -> returns true
        assertTrue(address.equals(new Gpa("Valid GPA")));

        // same object -> returns true
        assertTrue(address.equals(address));

        // null -> returns false
        assertFalse(address.equals(null));

        // different types -> returns false
        assertFalse(address.equals(5.0f));

        // different values -> returns false
        assertFalse(address.equals(new Gpa("Other Valid GPA")));
    }
}
