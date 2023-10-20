package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookmarkTest {

    @Test
    public void equals() {
        Bookmark bookmark = new Bookmark(true);

        // same values -> returns true
        assertTrue(bookmark.equals(new Bookmark(true)));

        // same object -> returns true
        assertTrue(bookmark.equals(bookmark));

        // null -> returns false
        assertFalse(bookmark.equals(null));

        // different types -> returns false
        assertFalse(bookmark.equals("Test"));

        // different values -> returns false
        assertFalse(bookmark.equals(new Bookmark(false)));
    }
}
