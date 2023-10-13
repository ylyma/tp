package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;


public class ListHiddenCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_listHiddenPersons_listHiddenSuccessful() {
        Person firstHiddenPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person secondHiddenPerson = model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased());
        firstHiddenPerson.getIsHidden().hide();
        secondHiddenPerson.getIsHidden().hide();

        CommandResult commandResult = new ListHiddenCommand().execute(model);

        String expectedMessage = ListHiddenCommand.MESSAGE_SUCCESS;

        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertCommandSuccess(new ListHiddenCommand(), model, ListHiddenCommand.MESSAGE_SUCCESS, new ModelManager(model.getAddressBook(), new UserPrefs()));
    }


}
