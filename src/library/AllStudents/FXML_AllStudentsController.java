/*
 * this class will show all students
 */
package library.AllStudents;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import library.Utils.DatabaseQueries;

/**
 * FXML Controller class
 *
 * @author mohamedfathidevo
 */
public class FXML_AllStudentsController implements Initializable {

    @FXML
    private TableView<StudentModel> tableView;
    @FXML
    private TableColumn<StudentModel, String> colName;
    @FXML
    private TableColumn<StudentModel, String> colID;
    @FXML
    private TableColumn<StudentModel, Integer> colBook;

    ObservableList<StudentModel> list = FXCollections.observableArrayList();

    /**
     * initialises the controller class.
     *
     * this function work automatically will get all students and displayed in
     * table view
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            String table = "students";
            DatabaseQueries databaseQueries = new DatabaseQueries();
            list = databaseQueries.getAllStudents(table);
        } catch (SQLException ex) {
            Logger.getLogger(FXML_AllStudentsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colBook.setCellValueFactory(new PropertyValueFactory<>("numberOfBook"));

        tableView.setItems(list);
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
