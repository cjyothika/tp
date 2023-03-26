package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    /**
     * The enum Sort.
     */
    public enum Sort {
        /**
         * Semyear sort.
         */
        SEMYEAR,
        /**
         * Grade sort.
         */
        GRADE,
        /**
         * Credit sort.
         */
        CREDIT,
        /**
         * Code sort.
         */
        CODE,
        /**
         * Tag sort.
         */
        TAG };
    /**
     * The constant DEFAULT_SORT.
     */
    public static final Sort DEFAULT_SORT = Sort.SEMYEAR;

    /**
     * Boolean to switch between screens
     */
    public final boolean isDisplayAllModules;
    /**
     * The Is display filtered modules.
     */
    public final boolean isDisplayFilteredModules;
    /**
     * The Is display progress.
     */
    public final boolean isDisplayProgress;

    /**
     * The Sort.
     */
    public final Sort sort;

    private final String feedbackToUser;

    /** The application should exit. */
    private final boolean exit;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     *
     * @param feedbackToUser           the feedback to user
     * @param isDisplayAllModules      the is display all modules
     * @param isDisplayProgress        the is display progress
     * @param isDisplayFilteredModules the is display filtered modules
     * @param sort                     the sort
     * @param exit                     the exit
     */
    public CommandResult(String feedbackToUser, boolean isDisplayAllModules,
            boolean isDisplayProgress, boolean isDisplayFilteredModules, Sort sort, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.isDisplayAllModules = isDisplayAllModules;
        this.isDisplayProgress = isDisplayProgress;
        this.isDisplayFilteredModules = isDisplayFilteredModules;
        this.sort = sort;
        this.exit = exit;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     *
     * @param feedbackToUser the feedback to user
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, true, false, false, DEFAULT_SORT,
                false);
    }

    /**
     * Gets feedback to user.
     *
     * @return the feedback to user
     */
    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    /**
     * Is exit boolean.
     *
     * @return the boolean
     */
    public boolean isExit() {
        return exit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && isDisplayAllModules == otherCommandResult.isDisplayAllModules
                && isDisplayFilteredModules == otherCommandResult.isDisplayFilteredModules
                && isDisplayProgress == otherCommandResult.isDisplayProgress
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, isDisplayAllModules, isDisplayFilteredModules, isDisplayProgress, exit);
    }

}
