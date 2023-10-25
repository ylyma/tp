package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class SortByGpaCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_sortByGpa_success() {
        int indexOfLastPerson = model.getFilteredPersonList().size() - 1;
        Person personWithHighestGpa = new PersonBuilder(model.getFilteredPersonList().get(indexOfLastPerson))
                .withGpa(5.0).build();
        Person personWithLowestGpa = new PersonBuilder(model.getFilteredPersonList().get(0))
                .withGpa(0.0).build();

        model.setPerson(model.getFilteredPersonList().get(0), personWithLowestGpa);
        model.setPerson(model.getFilteredPersonList().get(indexOfLastPerson), personWithHighestGpa);

        CommandResult commandResult = new SortByGpaCommand().execute(model);

        String expectedMessage = SortByGpaCommand.MESSAGE_SUCCESS;

        assertEquals(expectedMessage, commandResult.getFeedbackToUser());
        assertTrue(model.getFilteredPersonList().get(0).equals(personWithHighestGpa)
                && model.getFilteredPersonList().get(indexOfLastPerson).equals(personWithLowestGpa));
    }
}
