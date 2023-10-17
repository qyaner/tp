package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.SearchPatientCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.PatientNameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new SearchDentistCommand object
 */
public class SearchPatientCommandParser implements Parser<SearchPatientCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SearchDentistCommand
     * and returns a SearchDentistCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public SearchPatientCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SearchPatientCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new SearchPatientCommand(new PatientNameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }
}
