package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ApplicationModel;
import seedu.address.model.application.Application;

/**
 * Deletes an application identified using its displayed index from the internship book.
 */
public class DeleteApplicationCommand extends ApplicationCommand {

    public static final String COMMAND_WORD = "delete-app";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the application identified by the index number used in the displayed application list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_APPLICATION_SUCCESS = "Deleted Application: %1$s";

    private final Index targetIndex;

    public DeleteApplicationCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(ApplicationModel model, CommandHistory commandHistory) throws CommandException {
        requireNonNull(model);
        List<Application> lastShownList = model.getSortedApplicationList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_APPLICATION_DISPLAYED_INDEX);
        }

        Application applicationToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteApplication(applicationToDelete);
        model.commitInternshipBookChange();
        commandHistory.setLastCommandAsModify();
        return new CommandResult(String.format(MESSAGE_DELETE_APPLICATION_SUCCESS, applicationToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteApplicationCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteApplicationCommand) other).targetIndex)); // state check
    }
}
