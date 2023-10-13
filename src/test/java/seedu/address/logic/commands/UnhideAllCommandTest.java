package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;


public class UnhideAllCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_unhideAll_unhideAllSuccessful() throws CommandException {
        Person firstHiddenPerson = model.getFilteredPersonList().get(Index.fromZeroBased(0).getZeroBased());
        Person secondHiddenPerson = model.getFilteredPersonList().get(Index.fromZeroBased(1).getZeroBased());
        firstHiddenPerson.getIsHidden().hide();
        secondHiddenPerson.getIsHidden().hide();

        CommandResult commandResult = new UnhideAllCommand().execute(model);

        String expectedMessage = UnhideAllCommand.MESSAGE_SUCCESS;

        assertEquals(expectedMessage, commandResult.getFeedbackToUser());

        assertTrue(firstHiddenPerson.getIsHidden().equals(false) && secondHiddenPerson.getIsHidden().equals(false));

    }

}
