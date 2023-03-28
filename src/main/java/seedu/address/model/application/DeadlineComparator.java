package seedu.address.model.application;

import java.util.Comparator;

import seedu.address.logic.parser.SortApplicationCommandParser.SortingSequence;
import seedu.address.model.task.Task;

/**
 * Compares two applications based on the deadline of their upcoming task.
 * Applications with no tasks are ranked lower.
 */
public class DeadlineComparator implements Comparator<Application> {

    private final SortingSequence sortingSequence;

    public DeadlineComparator(SortingSequence sortingSequence) {
        this.sortingSequence = sortingSequence;
    }

    /**
     * Compares two applications such that the application with an earlier task
     * deadline will be considered smaller than the other application.
     * @param appOne the first application to be compared.
     * @param appTwo the second application, to be compared to the first one.
     * @return an integer that represents whether the first application is smaller
     *      than the second.
     */
    public int compareAscending(Application appOne, Application appTwo) {
        if (appOne.hasTask() && appTwo.hasTask()) {
            Task taskOne = appOne.getTask();
            Task taskTwo = appTwo.getTask();
            if (taskOne.getDeadline().isBefore(taskTwo.getDeadline())) {
                return -1;
            } else if (taskOne.getDeadline().isAfter(taskTwo.getDeadline())) {
                return 1;
            }
        } else {
            if (appOne.hasTask() && !appTwo.hasTask()) {
                return -1;
            } else if (!appOne.hasTask() && appTwo.hasTask()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int compare(Application appOne, Application appTwo) {
        if (sortingSequence.equals(SortingSequence.ASCENDING)) {
            return compareAscending(appOne, appTwo);
        } else {
            return -compareAscending(appOne, appTwo);
        }
    }
}
