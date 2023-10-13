package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.model.Model;
import seedu.address.model.person.IsHiddenPredicate;

/**
 * Lists all applicants in the applicant list to the user.
 */
public class ListHiddenCommand extends Command {

    public static final String COMMAND_WORD = "list-hidden";

    public static final String MESSAGE_SUCCESS = "Listed all hidden applicants";

    private final IsHiddenPredicate predicate = new IsHiddenPredicate(true);

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
