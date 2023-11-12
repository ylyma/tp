package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.UnhideCommand;

public class UnhideCommandParserTest {

    private UnhideCommandParser parser = new UnhideCommandParser();

    @Test
    public void parse_validArgs_returnsUnhideCommand() {
        assertParseSuccess(parser, "1", new UnhideCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseSuccess(parser, "a", new UnhideCommand(INDEX_FIRST_PERSON));
    }
}
