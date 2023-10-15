package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.attachment.Attachment;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Tag}.
 */
class JsonAdaptedAttachment {

    private final String fileString;

    /**
     * Constructs a {@code JsonAdaptedFile} with the given {@code fileString}.
     */
    @JsonCreator
    public JsonAdaptedAttachment(String fileString) {
        this.fileString = fileString;
    }

    /**
     * Converts a given {@code File} into this class for Jackson use.
     */
    public JsonAdaptedAttachment(Attachment source) {
        fileString = source.path.getAbsolutePath();
    }

    @JsonValue
    public String getFileString() {
        return fileString;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Attachment toModelType() throws IllegalValueException {
        if (!Attachment.isValidPath(fileString)) {
            throw new IllegalValueException(Attachment.MESSAGE_CONSTRAINTS);
        }
        return new Attachment(fileString);
    }

}
