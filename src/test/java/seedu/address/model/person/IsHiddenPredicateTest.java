package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class IsHiddenPredicateTest {

    @Test
    public void equals() {
        boolean firstPredicateIsHidden = true;
        boolean secondPredicateIsHidden = false;
        IsHiddenPredicate firstPredicate = new IsHiddenPredicate(firstPredicateIsHidden);
        IsHiddenPredicate secondPredicate = new IsHiddenPredicate(secondPredicateIsHidden);
        assertTrue(firstPredicate.equals(firstPredicate));
        IsHiddenPredicate firstPredicateCopy = new IsHiddenPredicate(firstPredicateIsHidden);
        assertTrue(firstPredicate.equals(firstPredicateCopy));
        assertFalse(firstPredicate.equals(1));
        assertFalse(firstPredicate.equals(null));
        assertFalse(firstPredicate.equals(secondPredicate));
        assertTrue(firstPredicate.equals(firstPredicate));
    }

    @Test
    public void test_isHidden_returnsTrue() {
        IsHiddenPredicate predicate = new IsHiddenPredicate(true);
        assertTrue(predicate.test(new PersonBuilder().withHidden(true).build()));
    }

    @Test
    public void test_isHidden_returnsFalse() {
        IsHiddenPredicate predicate = new IsHiddenPredicate(false);
        assertFalse(predicate.test(new PersonBuilder().withHidden(true).build()));
    }

    @Test
    public void toStringMethod() {
        IsHiddenPredicate predicate = new IsHiddenPredicate(true);

        String expected = IsHiddenPredicate.class.getCanonicalName() + "{isHidden=" + true + "}";
        assertEquals(expected, predicate.toString());
    }
}

