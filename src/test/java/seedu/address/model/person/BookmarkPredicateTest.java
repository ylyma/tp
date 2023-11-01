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
        IsBookmarkedPredicate firstPredicate = new IsBookmarkedPredicate(firstPredicateBookmark);
        IsBookmarkedPredicate secondPredicate = new IsBookmarkedPredicate(secondPredicateBookmark);
        assertTrue(firstPredicate.equals(firstPredicate));
        IsBookmarkedPredicate firstPredicateCopy = new IsBookmarkedPredicate(firstPredicateBookmark);
        assertTrue(firstPredicate.equals(firstPredicateCopy));
        assertFalse(firstPredicate.equals(1));
        assertFalse(firstPredicate.equals(null));
        assertFalse(firstPredicate.equals(secondPredicate));
        assertTrue(firstPredicate.equals(firstPredicate));
    }

    @Test
    public void test_isHidden_returnsTrue() {
        IsBookmarkedPredicate predicate = new IsBookmarkedPredicate(true);
        assertTrue(predicate.test(new PersonBuilder().withBookmark(true).build()));
    }

    @Test
    public void test_isHidden_returnsFalse() {
        IsBookmarkedPredicate predicate = new IsBookmarkedPredicate(false);
        assertFalse(predicate.test(new PersonBuilder().withBookmark(true).build()));
    }

    @Test
    public void toStringMethod() {
        IsBookmarkedPredicate predicate = new IsBookmarkedPredicate(true);

        String expected = IsBookmarkedPredicate.class.getCanonicalName() + "{isBookmarked=" + true + "}";
        assertEquals(expected, predicate.toString());
    }
}
