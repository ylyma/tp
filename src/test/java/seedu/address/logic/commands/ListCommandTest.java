package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.logic.parser.CliSyntax.FIELD_BOOKMARKED;
import static seedu.address.logic.parser.CliSyntax.FIELD_HIDDEN;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {
    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listHiddenPersons_listHiddenSuccessful() throws CommandException {
        Person hiddenPerson = new PersonBuilder().withHidden(true).build();
        model.setPerson(model.getFilteredPersonList().get(0), hiddenPerson);
        CommandResult commandResult = new ListCommand(FIELD_HIDDEN).execute(model);
        String expectedMessage = ListCommand.MESSAGE_SUCCESS;
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(model.getFilteredPersonList().get(0), hiddenPerson);
    }

    @Test
    public void execute_listBookmarkedPersons_listBookmarkedSuccessful() throws CommandException {
        Person bookmarkedPerson = new PersonBuilder().withBookmark(true).build();
        model.setPerson(model.getFilteredPersonList().get(0), bookmarkedPerson);
        CommandResult commandResult = new ListCommand(FIELD_BOOKMARKED).execute(model);
        String expectedMessage = ListCommand.MESSAGE_SUCCESS;
        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertEquals(model.getFilteredPersonList().get(0), bookmarkedPerson);
    }
}
