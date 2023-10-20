package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class BookmarkPredicateTest {

    @Test
    public void equals() {
        boolean firstPredicateBookmark = true;
        boolean secondPredicateBookmark = false;
        BookmarkPredicate firstPredicate = new BookmarkPredicate(firstPredicateBookmark);
        BookmarkPredicate secondPredicate = new BookmarkPredicate(secondPredicateBookmark);
        assertTrue(firstPredicate.equals(firstPredicate));
        BookmarkPredicate firstPredicateCopy = new BookmarkPredicate(firstPredicateBookmark);
        assertTrue(firstPredicate.equals(firstPredicateCopy));
        assertFalse(firstPredicate.equals(1));
        assertFalse(firstPredicate.equals(null));
        assertFalse(firstPredicate.equals(secondPredicate));
        assertTrue(firstPredicate.equals(firstPredicate));
    }

    @Test
    public void test_isHidden_returnsTrue() {
        BookmarkPredicate predicate = new BookmarkPredicate(true);
        assertTrue(predicate.test(new PersonBuilder().withBookmark(true).build()));
    }

    @Test
    public void test_isHidden_returnsFalse() {
        BookmarkPredicate predicate = new BookmarkPredicate(false);
        assertFalse(predicate.test(new PersonBuilder().withBookmark(true).build()));
    }

    @Test
    public void toStringMethod() {
        BookmarkPredicate predicate = new BookmarkPredicate(true);

        String expected = BookmarkPredicate.class.getCanonicalName() + "{isBookmarked=" + true + "}";
        assertEquals(expected, predicate.toString());
    }
}
