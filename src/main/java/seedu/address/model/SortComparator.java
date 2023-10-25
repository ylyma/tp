package seedu.address.model;

import static seedu.address.logic.parser.CliSyntax.FIELD_COMMENT;
import static seedu.address.logic.parser.CliSyntax.FIELD_EMAIL;
import static seedu.address.logic.parser.CliSyntax.FIELD_GPA;
import static seedu.address.logic.parser.CliSyntax.FIELD_NAME;
import static seedu.address.logic.parser.CliSyntax.FIELD_PHONE;
import static seedu.address.logic.parser.CliSyntax.FIELD_STUDENT_NUMBER;
import static seedu.address.logic.parser.CliSyntax.FIELD_TAG;

import java.util.Comparator;

import seedu.address.model.person.Person;

/**
 * Compares two persons based on the specified field.
 */
public class SortComparator implements Comparator<Person> {
    private final String fieldName;
    public SortComparator(String fieldName) {
        this.fieldName = fieldName;
    }
    @Override
    public int compare(Person p1, Person p2) {
        switch (fieldName) {
        case FIELD_NAME:
            return p1.getName().fullName.compareTo(p2.getName().fullName);
        case FIELD_STUDENT_NUMBER:
            return p1.getStudentNumber().value.compareTo(p2.getStudentNumber().value);
        case FIELD_GPA:
            return (int) ((p2.getGpa().value - p1.getGpa().value) * 100);
        case FIELD_PHONE:
            return p1.getPhone().value.compareTo(p2.getPhone().value);
        case FIELD_EMAIL:
            return p1.getEmail().value.compareTo(p2.getEmail().value);
        case FIELD_COMMENT:
            return p1.getComment().comment.length() - p2.getComment().comment.length();
        case FIELD_TAG:
            return p2.getTags().size() - p1.getTags().size();
        default:
            return 0;
        }
    }
}
