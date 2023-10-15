package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.address.model.attachment.Attachment;
import seedu.address.model.person.Person;

public class LocalAttachmentsStorage implements AttachmentsStorage {

    private Path basePath;

    public LocalAttachmentsStorage(Path basePath) {
        this.basePath = basePath;
    }
    
    @Override
    public Path getAttachmentsPath(Person person) {
        return Paths.get(basePath.toString(), person.getStudentNumber().value);
    }

    @Override
    public Attachment copyAttachment(Person person, Attachment attachmentToCopy) throws IOException {
        Path sourcePath = attachmentToCopy.file.toPath();
        String fileName = sourcePath.getFileName().toString();
        Path destPath = Paths.get(getAttachmentsPath(person).toString(), fileName);
        Files.copy(sourcePath, destPath);
        return new Attachment(destPath.toString());
    }
}
