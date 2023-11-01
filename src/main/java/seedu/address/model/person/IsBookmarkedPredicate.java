package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s isBookmarked matches the boolean given.
 */
public class IsBookmarkedPredicate implements Predicate<Person> {
    private final boolean isBookmarked;

    public IsBookmarkedPredicate(boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    @Override
    public boolean test(Person person) {
        return person.getIsBookmarked().value == isBookmarked;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof IsBookmarkedPredicate)) {
            return false;
        }

        IsBookmarkedPredicate otherBookmarkPredicate = (IsBookmarkedPredicate) other;
        return isBookmarked == otherBookmarkPredicate.isBookmarked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("isBookmarked", isBookmarked).toString();
    }
}
