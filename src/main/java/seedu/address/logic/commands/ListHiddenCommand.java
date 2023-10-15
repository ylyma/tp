package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all hidden applicants in the applicant list to the user.
 */
public class ListHiddenCommand extends Command {

    public static final String COMMAND_WORD = "list-hidden";

    public static final String MESSAGE_SUCCESS = "Listed all hidden applicants";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_HIDDEN_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
