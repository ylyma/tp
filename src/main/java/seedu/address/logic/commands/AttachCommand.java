package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FILE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.attachment.Attachment;
import seedu.address.model.person.Person;

/**
 * Attaches a file/files to an applicant (e.g. resume, certification).
 */
public class AttachCommand extends Command {

    public static final String COMMAND_WORD = "attach";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Attaches a file to the applicant "
            + "by the index number used in the displayed applicant list. This is done by copying\n "
            + "the files into the data directory.\n "
            + "Existing values will not be overwritten by new attachments.\n"
            + "Cannot have attachments with the same filename, rename files before attaching them.\n"
            + "Use the unattach command in order to remove attachments.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_FILE + "FILE]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_FILE + "samples/resume.pdf";
    public static final String MESSAGE_FAILED_TO_COPY = "Failed to copy attachment";

    private final Index index;
    private final List<Attachment> attachments;

    /**
     * Creates a new attach command, representing the attachment of a file/files to an
     * applicant at the specified index on the visible applicant list.
     *
     * @param index index of the applicant to attach the file to
     * @param filePaths the path(s) of the file/files to be attached
     */
    public AttachCommand(Index index, List<Attachment> attachments) {
        this.index = index;
        this.attachments = attachments;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        // 1. Read the contents of the existing directory
        // 2. Copy in all the new attachments, failing first if one of them fails
        // 3. Add the attachments to the model

        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToAttachTo = lastShownList.get(index.getZeroBased());

        List<Attachment> updatedAttachments = new ArrayList<>(personToAttachTo.getAttachments());
        try {
            for (Attachment attachment : attachments) {
                Attachment copiedAttachment = copyAttachment(
                    model.getUserPrefs().getAttachmentsBasePath(), attachment, personToAttachTo);
                updatedAttachments.add(copiedAttachment);
            }
        } catch (IOException e) {
            throw new CommandException(MESSAGE_FAILED_TO_COPY);
        }

        Person attachedPerson = new Person(
            personToAttachTo.getStudentNumber(),
            personToAttachTo.getName(),
            personToAttachTo.getPhone(),
            personToAttachTo.getEmail(),
            personToAttachTo.getGpa(),
            personToAttachTo.getTags(),
            personToAttachTo.getIsHidden(),
            updatedAttachments
        );
        model.setPerson(personToAttachTo, attachedPerson);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_UNHIDDEN_PERSONS);

        return new CommandResult(
            "Attached " + attachments.size() + " attachments to " + personToAttachTo.getName() + "!");
    }

    private Attachment copyAttachment(
        Path basePath,
        Attachment attachment,
        Person personToAttachTo
    ) throws IOException {
        Path sourcePath = attachment.file.toPath();
        String fileName = sourcePath.getFileName().toString();
        Path destPath = Paths.get(basePath.toString(), personToAttachTo.getStudentNumber().toString(), fileName);
        destPath.getParent().toFile().mkdirs();
        Files.copy(sourcePath, destPath);
        return new Attachment(destPath.toString());
    }
}
