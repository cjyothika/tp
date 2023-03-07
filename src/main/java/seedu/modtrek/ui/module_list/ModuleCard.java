package seedu.modtrek.ui.module_list;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import seedu.modtrek.model.module.Module;
import seedu.modtrek.model.tag.Tag;
import seedu.modtrek.ui.UiPart;

/**
 * The type Module card.
 */
public class ModuleCard extends UiPart<Region> {
    private static final String FXML = "module_list/ModuleCard.fxml";

    @FXML
    private Label moduleCardCode;

    @FXML
    private Label moduleCardCredits;

    @FXML
    private Label moduleCardGrade;

    @FXML
    private FlowPane moduleCardTagGroup;

    /**
     * Instantiates a new Module card.
     *
     * @param module the module
     */
    public ModuleCard(Module module) {
        super(FXML);

        moduleCardCode.setText(module.getCode().toString());
        moduleCardCredits.setText(module.getCredit().toString() + "MC");
        moduleCardGrade.setText(module.getGrade().toString());

        List<Tag> tags = new ArrayList(module.getTags());
        for (int i = 0; i < tags.size(); i++) {
            String tagName = tags.get(i).tagName;
            addTag(tagName, "red");
        }
    }

    private void addTag(String tagName, String tagColor /* TODO: change to enums */) {
        Label tag = new Label(tagName);
        tag.getStyleClass().addAll("module-card-tag", "module-card-tag-" + tagColor, "p2");
        moduleCardTagGroup.getChildren().add(tag);

        /* Add a helper text to moduleCardTag to show full description of tag, on hover. */
        Tooltip tagToolTip = new Tooltip("Computer Science Foundation");
        Tooltip.install(tag, tagToolTip);
        tagToolTip.setShowDelay(Duration.seconds(0.05));
    }
}
