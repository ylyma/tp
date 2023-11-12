package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.HideCommand;

public class HideCommandParserTest {

    private HideCommandParser parser = new HideCommandParser();

    @Test
    public void parse_validArgs_returnsHideCommand() {
        assertParseSuccess(parser, "1", new HideCommand(INDEX_FIRST_PERSON));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseSuccess(parser, "a", new HideCommand(INDEX_FIRST_PERSON));
    }
}
