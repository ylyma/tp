package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import java.nio.file.Path;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class ListHiddenCommandTest {
    @Test
    public void execute_listHiddenPersons_listHiddenSuccessful() {
        ModelStubWithPersons modelStubWithPersons = new ModelStubWithPersons(new PersonBuilder().build(),
                new PersonBuilder().build(), new PersonBuilder().build());
        ListHiddenCommand listHiddenCommand = new ListHiddenCommand();
        String expectedMessage = ListHiddenCommand.MESSAGE_SUCCESS;
        assertCommandSuccess(listHiddenCommand, modelStubWithPersons, expectedMessage, modelStubWithPersons.hiddenPersons());
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
    private class ModelStubWithPersons extends ModelStub {
        private final Person firstHiddenPerson;
        private final Person secondHiddenPerson;
        private final Person unhiddenPerson;

        ModelStubWithPersons(Person personOne, Person personTwo, Person personThree) {
            requireAllNonNull(personOne, personTwo, personThree);
            this.firstHiddenPerson = personOne;
            this.secondHiddenPerson = personTwo;
            this.unhiddenPerson = personThree;
        }

        public ModelStub hiddenPersons() {
            ModelStub hiddenList = new ModelStub();
            hiddenList.addPerson(firstHiddenPerson);
            hiddenList.addPerson(secondHiddenPerson);
            firstHiddenPerson.hide();
            secondHiddenPerson.hide();
            return hiddenList;
        }
    }

}