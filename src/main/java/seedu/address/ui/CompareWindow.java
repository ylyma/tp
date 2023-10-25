package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.MainApp;
import seedu.address.model.person.Gpa;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

import java.io.IOException;

public class CompareWindow extends Stage {

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
    private Label compareMessageLabel;

    public CompareWindow(Person person1, Person person2) {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/CompareWindow.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setTitle("Comparison Result");

        String compareMessage;
        Name name1 = person1.getName();
        Gpa gpa1 = person1.getGpa();
        Name name2 = person2.getName();
        Gpa gpa2 = person2.getGpa();

        person1Name.setText(name1.toString());
        person1Gpa.setText(gpa1.toString());
        person2Name.setText(name2.toString());
        person2Gpa.setText(gpa2.toString());

        if (gpa1.compareTo(gpa2) == 0) {
            compareMessage = "They have the same GPA, do look out for other criteria!";
        } else if (gpa1.compareTo(gpa2) > 0) {
            compareMessage = name1 + " has a higher GPA!";
        } else {
            compareMessage = name2 + " has a higher GPA!";
        }

        compareMessageLabel.setText(compareMessage);

        Scene scene = new Scene(fxmlLoader.getRoot());
        setWidth(900);
        setHeight(600);
        setScene(scene);
    }
}
