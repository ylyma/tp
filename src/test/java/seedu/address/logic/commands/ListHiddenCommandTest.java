package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ListHiddenCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_listHiddenPersons_listHiddenSuccessful() {
        Person hiddenPerson = new PersonBuilder().withHidden(true).build();
        model.setPerson(model.getFilteredPersonList().get(0), hiddenPerson);
        CommandResult commandResult = new ListHiddenCommand().execute(model);
        String expectedMessage = ListHiddenCommand.MESSAGE_SUCCESS;
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(model.getFilteredPersonList().get(0), hiddenPerson);
    }


}
