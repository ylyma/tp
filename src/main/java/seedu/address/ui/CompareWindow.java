package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import seedu.address.MainApp;
import seedu.address.model.person.Gpa;
import seedu.address.model.person.Person;

/**
 * The Compare Pop-up Window. Provides a separate JavaFX stage when a "compare" command is inputted.
 * This window is used to display and compare the details of two applicants,
 * including student number, name, and their relevant achievements.
 */
public class CompareWindow extends Stage {
    @FXML
    private Label person1StuNum;
    @FXML
    private Label person2StuNum;
    @FXML
    private Label person1Name;
    @FXML
    private Label person1Gpa;
    @FXML
    private Label person2Name;
    @FXML
    private Label person2Gpa;
    @FXML
    private Label nameLabel;
    @FXML
    private Label gpaLabel;
    @FXML
    private Rectangle gpa1Highlight;
    @FXML
    private Rectangle gpa2Highlight;

    /**
     * Creates a new instance of the CompareWindow with information about two persons to be compared.
     *
     * @param person1 The first person for comparison.
     * @param person2 The second person for comparison.
     */
    public CompareWindow(Person person1, Person person2) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/CompareWindow.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("Comparison Result");

        Gpa gpa1 = person1.getGpa();
        Gpa gpa2 = person2.getGpa();

        person1StuNum.setText(person1.getStudentNumber().toString());
        person1Name.setText(person1.getName().toString());
        person1Gpa.setText(gpa1.toString());

        person2StuNum.setText(person2.getStudentNumber().toString());
        person2Name.setText(person2.getName().toString());
        person2Gpa.setText(gpa2.toString());

        if (gpa1.compareTo(gpa2) > 0) {
            gpa1Highlight.setOpacity(0.33);
        } else if (gpa1.compareTo(gpa2) < 0) {
            gpa2Highlight.setOpacity(0.33);
        }

        Scene scene = new Scene(fxmlLoader.getRoot());
        setWidth(900);
        setHeight(600);
        setScene(scene);
    }
}
