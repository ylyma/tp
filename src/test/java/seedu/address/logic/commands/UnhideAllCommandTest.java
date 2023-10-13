package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class UnhideAllCommandTest {
    @Test
    public void execute_unhideAll_unhideAllSuccessful() {
        Person validPersonOne = new PersonBuilder().build();
        Person validPersonTwo = new PersonBuilder().build();
        Person validPersonThree = new PersonBuilder().build();
        ModelStubWithHiddenPersons modelStubWithHiddenPersons = new ModelStubWithHiddenPersons(validPersonOne,
                validPersonTwo, validPersonThree);
        ModelStubWithUnhiddenPersons modelStubWithUnhiddenPersons = new ModelStubWithUnhiddenPersons(validPersonOne,
                validPersonTwo, validPersonThree);
        UnhideAllCommand unhideAllCommand = new UnhideAllCommand();
        String expectedMessage = UnhideAllCommand.MESSAGE_SUCCESS;
        assertCommandSuccess(unhideAllCommand, modelStubWithHiddenPersons, expectedMessage, modelStubWithUnhiddenPersons);
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
     * A Model stub that contains two hidden people and one unhidden person.
     */
    private class ModelStubWithHiddenPersons extends ModelStub {
        private final Person firstHiddenPerson;
        private final Person secondHiddenPerson;
        private final Person unhiddenPerson;

        ModelStubWithHiddenPersons(Person personOne, Person personTwo, Person personThree) {
            requireAllNonNull(personOne, personTwo, personThree);
            this.firstHiddenPerson = personOne;
            this.secondHiddenPerson = personTwo;
            firstHiddenPerson.hide();
            secondHiddenPerson.hide();
            this.unhiddenPerson = personThree;
        }
    }
    /**
     * A Model stub that contains unhidden persons.
     */
    private class ModelStubWithUnhiddenPersons extends ModelStub {
        private final Person firstPerson;
        private final Person secondPerson;
        private final Person thirdPerson;

        ModelStubWithUnhiddenPersons(Person personOne, Person personTwo, Person personThree) {
            requireAllNonNull(personOne, personTwo, personThree);
            this.firstPerson = personOne;
            this.secondPerson = personTwo;
            this.thirdPerson = personThree;
        }
    }
}
