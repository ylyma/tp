package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.ui.MainWindow;

import static java.util.Objects.requireNonNull;

public class CompareCommand extends Command {

    public static final String COMMAND_WORD = "compare";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Compares two applicants side by side.\n"
            + "Parameters: INDEX1 and INDEX2 (must be a positive integers)\n"
            + "Example: " + COMMAND_WORD + " 1 2";

    private final Index index1;
    private final Index index2;

    public CompareCommand(Index index1, Index index2) {
        requireNonNull(index1);
        requireNonNull(index2);

        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (index1.equals(index2)) {
            throw new CommandException("Error: Please provide distinct indices. "
                    + "You cannot compare the same applicant.");
        }

        try {
            Person person1 = model.getFilteredPersonList().get(index1.getZeroBased());
            Person person2 = model.getFilteredPersonList().get(index2.getZeroBased());

            return new CommandResult("Comparison successful");
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Error: One or both of the specified applicants"
                    + " were not found in the list.");
        }
    }
}

