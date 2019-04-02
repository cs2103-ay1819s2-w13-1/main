package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddAppointmentCommand;
import seedu.address.logic.commands.AddDoctorCommand;
import seedu.address.logic.commands.AddMedHistCommand;
import seedu.address.logic.commands.AddPatientCommand;
import seedu.address.logic.commands.AddPrescriptionCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteMedHistCommand;
import seedu.address.logic.commands.DeletePatientCommand;
import seedu.address.logic.commands.EditPatientCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ListAppointmentCommand;
import seedu.address.logic.commands.ListMedHistCommand;
import seedu.address.logic.commands.ListPatientCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.SearchMedHistCommand;
import seedu.address.logic.commands.SearchPatientCommand;
import seedu.address.logic.commands.SearchPatientTagCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.SelectMedHistCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user inp
     * ut does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddPatientCommand.COMMAND_WORD:
            return new AddPatientCommandParser().parse(arguments);

        case ListPatientCommand.COMMAND_WORD:
            return new ListPatientCommand();

        case EditPatientCommand.COMMAND_WORD:
            return new EditPatientCommandParser().parse(arguments);

        case SearchPatientCommand.COMMAND_WORD:
            return new SearchPatientCommandParser().parse(arguments);

        case SearchPatientTagCommand.COMMAND_WORD:
            return new SearchPatientTagCommandParser().parse(arguments);

        case DeletePatientCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);



        case ListMedHistCommand.COMMAND_WORD:
            return new ListMedHistCommand();

        case SearchMedHistCommand.COMMAND_WORD:
            return new SearchMedHistCommandParser().parse(arguments);



        case AddDoctorCommand.COMMAND_WORD:
            return new AddDoctorCommandParser().parse(arguments);

        case AddAppointmentCommand.COMMAND_WORD:
            return new AddAppointmentCommandParser().parse(arguments);

        case ListAppointmentCommand.COMMAND_WORD:
            return new ListAppointmentCommandParser().parse(arguments);

        case AddMedHistCommand.COMMAND_WORD:
            return new AddMedHistCommandParser().parse(arguments);

        case DeleteMedHistCommand.COMMAND_WORD:
            return new DeleteMedHistCommandParser().parse(arguments);

        case AddPrescriptionCommand.COMMAND_WORD:
            return new AddPrescriptionCommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
            return new SelectCommandParser().parse(arguments);

        case SelectMedHistCommand.COMMAND_WORD:
            return new SelectMedHistCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}



