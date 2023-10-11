package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_FILE;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;

/**
 * Attaches a file/files to an applicant (e.g. resume, certification).
 */
public class AttachCommand extends Command {

    public static final String COMMAND_WORD = "attach";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Attaches a file to the applicant "
            + "by the index number used in the displayed applicant list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_FILE + "FILE]...\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_FILE + "samples/resume.pdf";

    private final Index index;
    private final List<String> filePaths;

    /**
     * Creates a new attach command, representing the attachment of a file/files to an
     * applicant at the specified index on the visible applicant list.
     *
     * @param index index of the applicant to attach the file to
     * @param filePaths the path(s) of the file/files to be attached
     */
    public AttachCommand(Index index, List<String> filePaths) {
        this.index = index;
        this.filePaths = filePaths;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Hello from attach" + index + filePaths);
    }
}
