package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Grade Point Average (Gpa) in the applicant list.
 * Guarantees: immutable; is valid as declared in {@link #isValidGpa(String)}
 */
public class Gpa {

    public static final String MESSAGE_CONSTRAINTS = "Gpa can take values from 0.00 to 5.00, and cannot be blank";

    /*
     * Single digit, followed by a period, followed by one to two digits.
     */
    public static final String VALIDATION_REGEX = "[0-5]\\.[0-9][0-9]?$";

    public final double value;

    /**
     * Constructs an {@code Gpa}.
     *
     * @param gpa A possible gpa of a person.
     */
    public Gpa(double gpa) {
        requireNonNull(gpa);
        checkArgument(isValidGpa(gpa), MESSAGE_CONSTRAINTS);
        value = gpa;
    }

    /**
     * Returns true if a given double is a valid Gpa.
     */
    public static boolean isValidGpa(double test) {
        return test >= 0.0 && test <= 5.0;
    }

    /**
     * Compares this GPA with another GPA and returns true if this GPA is greater.
     *
     * @param other The other Gpa object to compare with.
     * @return True if this GPA is greater than the other GPA, false otherwise.
     */
    public boolean isGreaterThan(Gpa other) {
        return this.value > other.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
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
        return value == otherGpa.value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

}
