package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Grade Point Average (Gpa) in the applicant list.
 * Guarantees: immutable; is valid as declared in {@link #isValidGpa(String)}
 */
public class Gpa {

    public static final String MESSAGE_CONSTRAINTS = "GPA can take values from 0.0-5.0, and it should not be blank";

    /**
     * Single digit, followed by a period, followed by one to two digits.
     */
    public static final String VALIDATION_REGEX = "[0-5]\\.[0-9][0-9]?$";

    public final String value;

    /**
     * Constructs an {@code Gpa}.
     *
     * @param gpa A possible gpa of a person.
     */
    public Gpa(String gpa) {
        requireNonNull(gpa);
        checkArgument(isValidGpa(gpa), MESSAGE_CONSTRAINTS);
        value = gpa;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidGpa(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Gpa)) {
            return false;
        }

        Gpa otherGpa = (Gpa) other;
        return value.equals(otherGpa.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
