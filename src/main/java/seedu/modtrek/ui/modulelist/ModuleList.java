package seedu.modtrek.ui.modulelist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.ui.UiPart;

/**
 * The type Module list.
 */
public class ModuleList extends UiPart<Region> {
    private static final String FXML = "modulelist/ModuleList.fxml";

    @FXML
    private VBox moduleList;

    /**
     * Instantiates a new Module list.
     *
     * @param modules the modules
     */
    public ModuleList(ObservableList<Module> modules) {
        super(FXML);
        displayModuleGroup(modules);
    }

    /**
     * Display module group.
     *
     * @param modules the modules
     */
    public void displayModuleGroup(ObservableList<Module> modules) {
        // TODO: render ModuleGroup dynamically
        Set<String> semYears = new HashSet<>();
        modules.forEach(x -> semYears.add(x.getSemYear().toString()));
        List<String> semYearsList = new ArrayList<>(semYears);
        for (String semY : semYearsList) {
            ModuleGroup moduleGroup1 = new ModuleGroup(semY, modules.filtered(x -> x.getSemYear()
                    .toString().equals(semY)));
            moduleList.getChildren().add(moduleGroup1.getRoot());
        }
    }
}
