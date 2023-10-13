package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.IsHiddenPredicate;
import seedu.address.model.person.Person;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Unhides all applicants from the list of all applicants.
 */
public class UnhideAllCommand extends Command {

    public static final String COMMAND_WORD = "unhide-all";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Unhides all applicants in all future lists of applicants.\n"
            + "Parameter: INDEX (must be a positive integer) \n"
            + "Example: " + COMMAND_WORD + " 1 ";

    public static final String MESSAGE_UNHIDE_ALL_SUCCESS = "All applicants unhidden from lists";
    private final IsHiddenPredicate hiddenApplicantsPredicate = new IsHiddenPredicate(true);

    private final IsHiddenPredicate unhiddenApplicantsPredicate = new IsHiddenPredicate(false);

    @Override
    public CommandResult execute(Model model) throws CommandException{
        requireNonNull(model);
        model.updateFilteredPersonList(hiddenApplicantsPredicate);
        List<Person> hiddenList = model.getFilteredPersonList();
        hiddenList.forEach(Person::unhide);
        model.updateFilteredPersonList(unhiddenApplicantsPredicate);
        return new CommandResult(String.format(MESSAGE_UNHIDE_ALL_SUCCESS));
    }
}
