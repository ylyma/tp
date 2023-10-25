package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all bookmarked applicants in the applicant list to the user.
 */
public class ListBookmarkedCommand extends Command {

    public static final String COMMAND_WORD = "list-bookmark";

    public static final String MESSAGE_SUCCESS = "Listed all bookmarked applicants.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_BOOKMARKED_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
