package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;

public class HideCommandTest {

    @Test
    public void execute_personHidden_hideSuccessful() throws Exception {
        ModelStubWithPerson modelStubWithPerson = new ModelStubWithPerson(new PersonBuilder().build());
        CommandResult commandResult = new HideCommand(Index.fromZeroBased(0)).execute(modelStubWithPerson);
        assertEquals(String.format(HideCommand.MESSAGE_HIDE_APPLICANT_SUCCESS, Messages.format(modelStubWithPerson.getFilteredPersonList().get(0))),
                commandResult.getFeedbackToUser());
        assertEquals(modelStubWithPerson.getFilteredPersonList().get(0).getIsHidden(), true);
    }

    @Test
    public void execute_indexOutOfRange_throwsCommandException() {
        ModelStubWithPerson modelStubWithPerson = new ModelStubWithPerson(new PersonBuilder().build());
        HideCommand hideCommand = new HideCommand(Index.fromZeroBased(1));
        assertCommandFailure(hideCommand, modelStubWithPerson, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        HideCommand hideFirstCommand = new HideCommand(INDEX_FIRST_PERSON);
        HideCommand hideSecondCommand = new HideCommand(INDEX_SECOND_PERSON);

        assertTrue(hideFirstCommand.equals(hideFirstCommand));

        HideCommand hideFirstCommandCopy = new HideCommand(INDEX_FIRST_PERSON);\
        assertTrue(hideFirstCommand.equals(hideFirstCommandCopy));

        assertFalse(hideFirstCommand.equals(1));

        assertFalse(hideFirstCommand.equals(null));

        assertFalse(hideFirstCommand.equals(hideSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        HideCommand hideCommand = new HideCommand(targetIndex);
        String expected = HideCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, hideCommand.toString());
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void showPersonAtIndex(Index index) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single hidden person.
     */
    private class ModelStubWithHiddenPerson extends HideCommandTest.ModelStub {
        private final Person person;

        ModelStubWithHiddenPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }

        public boolean hasHiddenPerson(Person person) {
            requireNonNull(person);
            return this.person.isSamePerson(person) && this.person.getIsHidden();
        }
    }
    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends AddCommandTest.ModelStub {
        private final Person person;

        ModelStubWithPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }
    }
}
