package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ListBookmarkedCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void execute_listBookmarkedPersons_listBookmarkedSuccessful() {
        Person bookmarkedPerson = new PersonBuilder().withBookmark(true).build();
        model.setPerson(model.getFilteredPersonList().get(0), bookmarkedPerson);
        CommandResult commandResult = new ListBookmarkedCommand().execute(model);
        String expectedMessage = ListBookmarkedCommand.MESSAGE_SUCCESS;
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(model.getFilteredPersonList().get(0), bookmarkedPerson);
    }


}
