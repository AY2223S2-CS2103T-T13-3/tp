package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.application.Application;

/**
 * Unmodifiable view of an application book
 */
public interface ReadOnlyApplicationBook {

    /**
     * Returns an unmodifiable view of the applications list.
     * This list will not contain any duplicate Applications.
     */
    ObservableList<Application> getApplicationList();

}
