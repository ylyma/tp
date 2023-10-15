package seedu.address.model.person;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.attachment.Attachment;

public class AttachmentTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Attachment(null));
    }

    @Test
    public void constructor_invalidPathString_throwsIllegalArgumentException() {
        String invalidPathString = "a\nb";
        assertThrows(IllegalArgumentException.class, () -> new Attachment(invalidPathString));
    }

    @Test
    public void isValidPathString() {
        // null path string
        assertThrows(NullPointerException.class, () -> Attachment.isValidPath(null));
    }

}
