package seedu.modtrek.ui.cli;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.modtrek.ui.UiPart;

/**
 * The type User dialog.
 */
public class UserDialog extends UiPart<Region> {
    private static final String FXML = "cli/UserDialog.fxml";

    @FXML
    private Label userDialogText;

    /**
     * Instantiates a new User dialog.
     *
     * @param text the text
     */
    public UserDialog(String text) {
        super(FXML);
        userDialogText.setText(text);
    }
}
