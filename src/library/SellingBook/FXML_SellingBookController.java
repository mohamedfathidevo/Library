/*
 * this class to sell book and show price
 */
package library.SellingBook;

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
import javafx.stage.Stage;
import library.Utils.DatabaseQueries;

/**
 * FXML Controller class
 *
 * @author mohamedfathidevo
 */
public class FXML_SellingBookController implements Initializable {

    private final String regular = "^[0-9]*$";

    @FXML
    private TextField searchET;
    @FXML
    private TextField numberBookET;
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
     * this fuction to sell book by name , at first, will check if book is exists or not
     * if not will show message , if true -> it will check for avalible quantity
     * if the quantity available it will show the price and deducted from database
     * and if the quantity after selling become zero will delete row from database
     * in this function i will user queries select, update, delete 
     */
    @FXML
    public void sellBook(ActionEvent actionEvent) throws SQLException {
        DatabaseQueries databaseQueries = new DatabaseQueries();
        if (!numberBookET.getText().isEmpty() && !searchET.getText().isEmpty()) {
            if (numberBookET.getText().matches(regular)) {
                String nameBook = searchET.getText().trim();
                int number = Integer.parseInt(numberBookET.getText().trim());
                ResultSet resultSet = databaseQueries.searchName(nameBook);
                if (resultSet.next()) {
                    int availableBook = resultSet.getInt("availableQuantity");
                    if (availableBook >= number) {
                        int newAvalibleQuantity = availableBook - number;
                        int price = resultSet.getInt("price");
                        databaseQueries.updateNumberAvailableBook(newAvalibleQuantity, nameBook);
                        if (newAvalibleQuantity == 0) {
                            databaseQueries.deleteRowByName(nameBook);
                        }
                        searchET.setText("");
                        numberBookET.setText("");
                        resultTV.setText("price =" + number * price);
                        resultSet.close();
                    } else {
                        resultTV.setText("the quantity is not available");
                    }
                } else {
                    resultTV.setText("there are no books with this name");
                }
            } else {
                resultTV.setText("check your input");
            }
        } else {
            resultTV.setText("check your input");
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
