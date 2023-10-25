package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Sorts all applicants by GPA.
 */
public class SortByGpaCommand extends Command {

    public static final String COMMAND_WORD = "sort-gpa";

    public static final String MESSAGE_SUCCESS = "Sorted all applicants by GPA";

    public static final String MESSAGE_EMPTY_LIST = "No applicants to sort";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (model.getFilteredPersonList().isEmpty()) {
            return new CommandResult(MESSAGE_EMPTY_LIST);
        }
        model.sortFilteredPersonList(Model.COMPARATOR_SORT_BY_GPA);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}

