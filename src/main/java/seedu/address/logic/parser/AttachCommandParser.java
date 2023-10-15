package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FILE;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AttachCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new AttachCommand object
 */
public class AttachCommandParser implements Parser<AttachCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AttachCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_FILE);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AttachCommand.MESSAGE_USAGE), pe);
        }

        if (!argMultimap.getValue(PREFIX_FILE).isPresent()) {
            throw new ParseException("<INSERT MESSAGE HERE>");
        }
        List<String> filePaths = argMultimap.getAllValues(PREFIX_FILE);

        return new AttachCommand(index, filePaths);
    }

}
