package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Bookmark;
import seedu.address.model.person.Comment;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gpa;
import seedu.address.model.person.IsHidden;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;


/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setPhone(person.getPhone());
        descriptor.setEmail(person.getEmail());
        descriptor.setGpa(person.getGpa());
        descriptor.setComment(person.getComment());
        descriptor.setTags(person.getTags());
        descriptor.setIsHidden(person.getIsHidden());
        descriptor.setBookmark(person.getBookmark());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Gpa} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withGpa(double gpa) {
        descriptor.setGpa(new Gpa(gpa));
        return this;
    }

    /**
     * Sets the {@code Comment} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withComment(String comment) {
        descriptor.setComment(new Comment(comment));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    /**
     * Sets the {@code IsHidden} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withHidden(boolean isHidden) {
        descriptor.setIsHidden(new IsHidden(isHidden));
        return this;
    }

    /**
     * Sets the {@code IsHidden} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withBookmark(boolean bookmark) {
        descriptor.setBookmark(new Bookmark(bookmark));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
