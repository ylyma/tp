package seedu.address.model.person;

import seedu.address.commons.util.ToStringBuilder;

import java.util.function.Predicate;

public class IsHiddenPredicate implements Predicate<Person> {
    private final boolean isHidden;

    public IsHiddenPredicate(boolean isHidden) {
        this.isHidden = isHidden;
    }

    @Override
    public boolean test(Person person) {
        return person.getIsHidden() == this.isHidden;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof IsHiddenPredicate)) {
            return false;
        }

        IsHiddenPredicate otherIsHiddenPredicate = (IsHiddenPredicate) other;
        return isHidden == otherIsHiddenPredicate.isHidden;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("isHidden", isHidden).toString();
    }
}
