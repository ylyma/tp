package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

/**
 * Represents an attachment in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidPath(String)}
 */
public class Attachment {

    public static final String MESSAGE_CONSTRAINTS = "Attachments should be valid file paths";

    public final File path;

    /**
     * Constructs an {@code Attachment}.
     *
     * @param tagName A valid tag name.
     */
    public Attachment(String pathString) {
        requireNonNull(pathString);
        checkArgument(isValidPath(pathString), MESSAGE_CONSTRAINTS);
        File path = new File(pathString);
        this.path = path;
    }

    /**
     * Returns true if a given string is a valid file path.
     */
    public static boolean isValidPath(String test) {
        try {
            Paths.get(test);
            return new File(test).exists();
        } catch (InvalidPathException e) {
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Attachment)) {
            return false;
        }

        Attachment otherFile = (Attachment) other;
        return path.equals(otherFile.path);
    }

    @Override
    public int hashCode() {
        return path.getAbsolutePath().hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + path.getAbsolutePath() + ']';
    }

}
