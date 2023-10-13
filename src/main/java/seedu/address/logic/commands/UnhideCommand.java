package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.IsHiddenPredicate;
import seedu.address.model.person.Person;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Unhides an applicant from the list of all applicants.
 */
public class UnhideCommand extends Command {

    public static final String COMMAND_WORD = "unhide";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Unhides an applicant, identified by the index number "
            + "used in the list of hidden applicants, in all future lists of applicants.\n"
            + "Parameter: INDEX (must be a positive integer) \n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_HIDE_PERSON_SUCCESS = "Person %1$s hidden from lists";

    public final Index targetIndex;
    private final IsHiddenPredicate hiddenApplicantsPredicate = new IsHiddenPredicate(true);
    private final IsHiddenPredicate unhiddenAppliantsPredicate = new IsHiddenPredicate(false);

    public UnhideCommand(Index targetIndex) {
        requireAllNonNull(targetIndex);

        this.targetIndex = targetIndex;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException{
        requireNonNull(model);
        model.updateFilteredPersonList(hiddenApplicantsPredicate);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (this.targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToUnhide = lastShownList.get(targetIndex.getZeroBased());
        personToUnhide.unhide();
        model.updateFilteredPersonList(unhiddenAppliantsPredicate);
        return new CommandResult(String.format(MESSAGE_HIDE_PERSON_SUCCESS, Messages.format(personToUnhide)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof UnhideCommand)) {
            return false;
        }

        UnhideCommand e = (UnhideCommand) other;
        return targetIndex.equals(e.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
