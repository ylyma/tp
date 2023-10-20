package seedu.address.model.person;

/**
 * Represents whether a Person is bookmarked in the address book.
 */
public class Bookmark {
    public final boolean value;

    /**
     * Constructs a {@code Bookmark}.
     */
    public Bookmark(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Bookmark)) {
            return false;
        }

        Bookmark otherBookmark = (Bookmark) other;
        return value == otherBookmark.value;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(value);
    }

}
