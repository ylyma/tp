package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CompareCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompareCommandParserTest {

    private final CompareCommandParser parser = new CompareCommandParser();


    @Test
    public void parse_invalidFormat_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("invalidArgs"));
    }

    @Test
    public void parse_missingIndex_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("1"));
    }

    @Test
    public void parse_invalidIndexFormat_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("one two"));
    }

    @Test
    public void parse_extraArgs_throwsParseException() {
        assertThrows(ParseException.class, () -> parser.parse("1 2 3"));
    }
}
