package seedu.modtrek.ui.cli;

import static seedu.modtrek.ui.cli.CommandBox.ERROR_STYLE_CLASS;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.modtrek.logic.commands.CommandResult;
import seedu.modtrek.logic.commands.exceptions.CommandException;
import seedu.modtrek.logic.parser.exceptions.ParseException;
import seedu.modtrek.ui.UiPart;

/**
 * The type Cli section.
 */
public class CliSection extends UiPart<Region> {
    private static final String FXML = "cli/CliSection.fxml";

    private CommandExecutor commandExecutor;

    @FXML
    private ScrollPane cliScreenScrollContainer;

    @FXML
    private VBox cliScreen;

    @FXML
    private TextField cliInput;

    /**
     * Instantiates a new Cli section.
     *
     * @param commandExecutor the command executor
     */
    public CliSection(CommandExecutor commandExecutor) {
        super(FXML);

        this.commandExecutor = commandExecutor;
        /* Scroll down to the end every time cliScreen's height changes. */
        cliScreen.heightProperty().addListener((observable) -> cliScreenScrollContainer.setVvalue(1.0));
    }

    /**
     * Handles the Enter button pressed event.
     */
    @FXML
    private void handleCommandEntered() {
        String commandText = cliInput.getText();
        if (commandText.equals("")) {
            return;
        }

        /* Remove the initial welcome dialog shown on cliScreen on app launch */
        cliScreen.getChildren().remove(cliScreen.lookup("#cli-screen-welcome-dialog"));

        addUserDialog(commandText);

        /* TODO: Call execute() here... */
        try {
            commandExecutor.execute(commandText);
            cliInput.setText("");
        } catch (CommandException | ParseException e) {
            setStyleToIndicateCommandFailure();
        }
    }

    private void addUserDialog(String text) {
        UserDialog userDialog = new UserDialog(text);
        cliScreen.getChildren().add(userDialog.getRoot());
    }

    /**
     * Add system dialog.
     *
     * @param text      the text
     * @param isSuccess the is success
     */
    public void addSystemDialog(String text, boolean isSuccess) {
        SystemDialog systemDialog = new SystemDialog(text, isSuccess);
        cliScreen.getChildren().add(systemDialog.getRoot());
    }

    /**
     * Sets the command box style to use the default style.
     */
    private void setStyleToDefault() {
        cliInput.getStyleClass().remove(ERROR_STYLE_CLASS);
    }

    /**
     * Sets the command box style to indicate a failed command.
     */
    private void setStyleToIndicateCommandFailure() {
        ObservableList<String> styleClass = cliInput.getStyleClass();

        if (styleClass.contains(ERROR_STYLE_CLASS)) {
            return;
        }

        styleClass.add(ERROR_STYLE_CLASS);
    }

    /**
     * Represents a function that can execute commands.
     */
    @FunctionalInterface
    public interface CommandExecutor {
        /**
         * Executes the command and returns the result.
         *
         * @param commandText the command text
         * @return the command result
         * @throws CommandException the command exception
         * @throws ParseException   the parse exception
         * @see seedu.modtrek.logic.Logic#execute(String) seedu.modtrek.logic.Logic#execute(String)
         */
        CommandResult execute(String commandText) throws CommandException, ParseException;
    }
}
