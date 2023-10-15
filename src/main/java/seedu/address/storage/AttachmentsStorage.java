package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;

import seedu.address.model.attachment.Attachment;
import seedu.address.model.person.Person;

/**
 * Represents a storage for many {@link seedu.address.model.Attachment}.
 */
public interface AttachmentsStorage {

    /**
     * Returns the file path of the attachments directory for the given person.
     */
    Path getAttachmentsPath(Person person);

    /**
     * Copies the given {@link seedu.address.model.Attachment} into the attachments directory
     * of the given person.
     * @param person to find the correct attachments directory.
     * @param attachment to copy.
     * @return The copied attachment representing the new location of the attachment.
     * @throws IOException if there was any problem writing to the file.
     */
    Attachment copyAttachment(Person person, Attachment attachmentToCopy) throws IOException;

}
