/*
 * this class will show all book from database
 */
package library.AllBooks;

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
public class FXML_AllBooksController implements Initializable {

    @FXML
    private TableView<BookModel> tableView;
    @FXML
    private TableColumn<BookModel, String> colName;
    @FXML
    private TableColumn<BookModel, String> colAuthor;
    @FXML
    private TableColumn<BookModel, Double> colPrice;
    @FXML
    private TableColumn<BookModel, Integer> colQuantity;
    @FXML
    private TableColumn<BookModel, Integer> colAvalible;

    ObservableList<BookModel> list = FXCollections.observableArrayList();

    /**
     * initialises the controller class.
     *
     * this function work automatically will get all book and displayed in table
     * view
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("bookPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colAvalible.setCellValueFactory(new PropertyValueFactory<>("avalibleQuantity"));

        try {
            DatabaseQueries databaseQueries = new DatabaseQueries();
            String tableName = "books";
            list = databaseQueries.getAllBooks(tableName);
        } catch (SQLException ex) {
            Logger.getLogger(FXML_AllBooksController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
