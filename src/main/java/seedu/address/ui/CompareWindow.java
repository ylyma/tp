package seedu.address.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seedu.address.model.person.Gpa;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

public class CompareWindow extends Stage {

    public CompareWindow(Person person1, Person person2) {
        setTitle("Comparison Result");

        String compareMessage;
        Name name1 = person1.getName();
        Gpa gpa1 = person1.getGpa();
        Name name2 = person2.getName();
        Gpa gpa2 = person2.getGpa();

        Label person1Name = new Label(name1.toString());
        Label person1Gpa = new Label(gpa1.toString());
        Label person2Name = new Label(name2.toString());
        Label person2Gpa = new Label(gpa2.toString());
        Label nameLabel = new Label("Name");
        Label gpaLabel = new Label("GPA");


        if (gpa1.compareTo(gpa2) == 0) {
            compareMessage = "They have the same GPA, do look out for other criteria!";
        } else if (gpa1.compareTo(gpa2) > 0) {
            compareMessage = name1 + " has a higher GPA!";
        } else {
            compareMessage = name2 + " has a higher GPA!";
        }

        Label compareMessageLabel = new Label(compareMessage);
        compareMessageLabel.setFont(Font.font(40));

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(person1Name, 0, 0);
        gridPane.add(nameLabel, 1, 0);
        gridPane.add(person2Name, 2, 0);

        gridPane.add(person1Gpa, 0, 1);
        gridPane.add(gpaLabel, 1, 1);
        gridPane.add(person2Gpa, 2, 1);

        gridPane.add(compareMessageLabel, 1, 2);

        GridPane.setHalignment(nameLabel, HPos.CENTER);
        GridPane.setHalignment(gpaLabel, HPos.CENTER);

        Scene scene = new Scene(gridPane);

        setWidth(900);
        setHeight(600);

        setScene(scene);
    }
}

