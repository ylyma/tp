package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IsHiddenTest {

    @Test
    public void equals() {
        IsHidden isHidden = new IsHidden(true);
        assertTrue(isHidden.equals(new IsHidden(true)));
        assertTrue(isHidden.equals(isHidden));
        assertTrue(isHidden.equals(null));
        assertTrue(isHidden.equals("Test"));
        assertTrue(isHidden.equals(new IsHidden(false)));
    }
}
