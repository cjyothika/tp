package seedu.modtrek.ui.module_list;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.ui.UiPart;

public class ModuleList extends UiPart<Region> {
    private static final String FXML = "module_list/ModuleList.fxml";

    @FXML
    private VBox moduleList;

    public ModuleList(ObservableList<Module> modules) {
        super(FXML);
        displayModuleGroup(modules);
    }

    public void displayModuleGroup(ObservableList<Module> modules) {
        // TODO: render ModuleGroup dynamically
        ModuleGroup moduleGroup1 = new ModuleGroup("mods", modules);
        moduleList.getChildren().add(moduleGroup1.getRoot());
    }
}
