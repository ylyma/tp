package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Comparator;

import seedu.address.model.Model;
import seedu.address.model.SortComparator;
import seedu.address.model.person.Person;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all applicants by the given field name.\n"
            + "Parameters: FIELD_NAME\n"
            + "Example: " + COMMAND_WORD + " -gpa";
    public static final String MESSAGE_SUCCESS = "Sorted all applicants";
    public static final String MESSAGE_EMPTY_LIST = "No applicants to sort.";
    public final String fieldName;
    public SortCommand(String fieldName) {
        requireNonNull(fieldName);
        this.fieldName = fieldName;
    }
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (model.getFilteredPersonList().isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
        Comparator<Person> comparator = new SortComparator(fieldName);
        model.sortFilteredPersonList(comparator);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
