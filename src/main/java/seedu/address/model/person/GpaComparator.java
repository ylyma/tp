package seedu.address.model.person;

import java.util.Comparator;

/**
 * Compares two persons based on their GPA.
 */
public class GpaComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return (int) ((o2.getGpa().value - o1.getGpa().value) * 100);
	}

}
