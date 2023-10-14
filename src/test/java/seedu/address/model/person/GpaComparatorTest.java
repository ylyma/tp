package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class GpaComparatorTest {

    @Test
    public void compare_gpaIsSame_returnsZero() {
        GpaComparator comparator = new GpaComparator();
        Person person1 = new PersonBuilder().withGpa(3.5).build();
        Person person2 = new PersonBuilder().withGpa(3.5).build();
        assertEquals(0, comparator.compare(person1, person2));
    }

    @Test
    public void compare_gpaIsDifferent_returnsNonZero() {
        GpaComparator comparator = new GpaComparator();
        Person person1 = new PersonBuilder().withGpa(3.5).build();
        Person person2 = new PersonBuilder().withGpa(3.6).build();
        assertEquals(10, comparator.compare(person1, person2));
    }
}
