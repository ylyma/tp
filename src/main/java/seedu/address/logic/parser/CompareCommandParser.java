package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CompareCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class CompareCommandParser implements Parser<CompareCommand> {

    @Override
    public CompareCommand parse(String args) throws ParseException {
        try {
            String[] splitArgs = args.trim().split("\\s+");
            Index index1 = ParserUtil.parseIndex(splitArgs[0]);
            Index index2 = ParserUtil.parseIndex(splitArgs[1]);
            return new CompareCommand(index1, index2);
        } catch (ParseException pe) {
            throw new ParseException("Error: Please provide valid indices for both applicants."
                    + "Follow the format: compare INDEX1 INDEX2.", pe);
        }
    }
}
