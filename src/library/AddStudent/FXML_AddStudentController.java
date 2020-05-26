/*
 * this class for add students to database
 */
package library.AddStudent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import library.Utils.DatabaseQueries;

/**
 * FXML Controller class
 *
 * @author mohamedfathidevo
 */
public class FXML_AddStudentController implements Initializable {

    // i will use this for check if the input is integer or not like input.maches(regular) ..
    private final String regular = "^[0-9]*$";

    @FXML
    private TextField studentNameET;
    @FXML
    private TextField studentIdET;
    @FXML
    private Label resultTV;

    /**
     * initialises the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /*
     * this function with take all input and check on them like string int ..
     * after that if all conditions true , the data will save in database
     * if any condition is false , wrong message will appear
     */
    public void saveToDatabase(ActionEvent actionEvent) throws SQLException {
        String name = studentNameET.getText().trim();
        String id = studentIdET.getText().trim();
        if (!name.isEmpty() && !id.isEmpty()) {
            if (id.matches(regular)) {
                DatabaseQueries databaseQueries = new DatabaseQueries();
                databaseQueries.addStudent(name, id);
                studentNameET.setText("");
                studentIdET.setText("");
                resultTV.setTextFill(Color.BLUE);
                resultTV.setText("the Student added");
            } else {
                resultTV.setTextFill(Color.RED);
                resultTV.setText("please check your input");
            }
        } else {
            resultTV.setTextFill(Color.RED);
            resultTV.setText("please check your input");
        }
    }

    /*
     * this fuction will take you to main menu
     */
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/library/FXMLMain.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
