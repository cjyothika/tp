package seedu.modtrek.ui.graphics;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.ui.UiPart;
import seedu.modtrek.ui.modulelist.ModuleList;

/**
 * The type Graphics section.
 */
public class GraphicsSection extends UiPart<Region> {
    private static final String FXML = "graphics/GraphicsSection.fxml";

    @FXML
    private Label sectionHeaderTitle;

    @FXML
    private Label sectionHeaderSubtitle;

    @FXML
    private VBox sectionBody;

    @FXML
    private GridPane moduleList;

    /**
     * Instantiates a new Graphics section.
     *
     * @param modules the modules
     */
    public GraphicsSection(ObservableList<Module> modules) {
        super(FXML);
        displayModuleList(modules);
    }

    /**
     * Display progress.
     */
    // TODO: next iteration
    public void displayProgress() {
    }

    /**
     * Display module list.
     *
     * @param modules the modules
     */
    public void displayModuleList(ObservableList<Module> modules) {
        sectionHeaderTitle.setText("Your Modules");
        sectionHeaderSubtitle.setText("in total");

        // TODO: render ModuleList dynamically
        ModuleList moduleList = new ModuleList(modules);
        sectionBody.getChildren().clear();
        sectionBody.getChildren().add(moduleList.getRoot());
    }
}
