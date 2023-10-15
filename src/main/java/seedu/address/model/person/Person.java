package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents an applicant in the TA applicant list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Gpa gpa;
    private final Set<Tag> tags = new HashSet<>();
    private final IsHidden isHidden;
    private final List<Attachment> attachments = new ArrayList<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Gpa gpa, Set<Tag> tags, IsHidden isHidden, List<Attachment> attachments) {
        requireAllNonNull(name, phone, email, gpa, tags, isHidden);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gpa = gpa;
        this.tags.addAll(tags);
        this.isHidden = isHidden;
        this.attachments.addAll(attachments);
    }

    public Name getName() {
        return this.name;
    }

    public Phone getPhone() {
        return this.phone;
    }

    public Email getEmail() {
        return this.email;
    }

    public Gpa getGpa() {
        return this.gpa;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns an immutable isHidden value, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */

    public IsHidden getIsHidden() {
        return this.isHidden;
    }

    /**
     * Returns an immutable attachment list, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public List<Attachment> getAttachments() {
        return Collections.unmodifiableList(attachments);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && gpa.equals(otherPerson.gpa)
                && tags.equals(otherPerson.tags)
                && isHidden.equals(getIsHidden())
                && attachments.equals(otherPerson.attachments);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, gpa, tags, isHidden, attachments);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("gpa", gpa)
                .add("tags", tags)
                .add("hidden", isHidden)
                .add("attachments", attachments)
                .toString();
    }

}
