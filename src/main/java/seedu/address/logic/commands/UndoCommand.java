package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.ApplicationModel.PREDICATE_SHOW_ALL_APPLICATIONS;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ApplicationModel;

/**
 * Reverts the displayed internship book to its previous state.
 */
public class UndoCommand extends ApplicationCommand {

    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_SUCCESS = "The last command that modified the internship book"
            + " has been undone!\nSuccessfully undo the following command, '%s'";

    public static final String MESSAGE_FAILURE = "There is no command to undo!"
            + " The command to be undone need to previously modified the internship book.";

    @Override
    public CommandResult execute(ApplicationModel model, CommandHistory commandHistory) throws CommandException {
        requireNonNull(model);

        if (!model.canUndoInternshipBook()) {
            throw new CommandException(MESSAGE_FAILURE);
        }

        model.undoInternshipBook();
        model.updateFilteredApplicationList(PREDICATE_SHOW_ALL_APPLICATIONS);
        String commandToUndo = commandHistory.getPreviousModifyCommand();

        return new CommandResult(String.format(MESSAGE_SUCCESS, commandToUndo));
    }
}
