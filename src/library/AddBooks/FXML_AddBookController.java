/*
 * this class for add books to database
 */
package library.AddBooks;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
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
public class FXML_AddBookController implements Initializable {

    // i will use this for check if the input is integer or not like input.maches(regular) ..
    private final String regular = "^[0-9]*$";

    @FXML
    private TextField bookNameET;
    @FXML
    private TextField authorNameET;
    @FXML
    private TextField bookPriceET;
    @FXML
    private TextField quantityET;
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
        DatabaseQueries databaseQueries = new DatabaseQueries();
        String name = bookNameET.getText().trim();
        String author = authorNameET.getText().trim();
        String price = bookPriceET.getText().trim();
        String quantity = quantityET.getText().trim();

        if (!name.isEmpty() && !author.isEmpty() && !price.isEmpty() && !quantity.isEmpty()) {
            if (price.matches(regular) && quantity.matches(regular)) {
                ResultSet resultSet = databaseQueries.searchName(name);
                if (!resultSet.next()) {
                    databaseQueries.addBook(name, author, price, quantity);
                    bookNameET.setText("");
                    authorNameET.setText("");
                    bookPriceET.setText("");
                    quantityET.setText("");
                    resultTV.setTextFill(Color.BLUE);
                    resultTV.setText("the book added");
                } else {
                    resultTV.setTextFill(Color.RED);
                    resultTV.setText("this book already exists");
                }
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
