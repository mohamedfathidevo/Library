/*
 * this fuction to use all queries in my appilication
 * when i need to use any function i will make objects and call functions 
 */
package library.Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.AllBooks.BookModel;
import library.AllStudents.StudentModel;

/**
 *
 * @author mohamedfathidevo
 */
public class DatabaseQueries {

    private final Connection connection;
    private final Statement statement;
    ResultSet resultSet;

    public DatabaseQueries() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.statement = connection.createStatement();
    }

    //to get all book from database
    public ObservableList<BookModel> getAllBooks(String tableName) throws SQLException {
        ObservableList<BookModel> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM `" + tableName + "`";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            list.add(new BookModel(resultSet.getString("name"), resultSet.getString("author"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("quantity"),
                    resultSet.getInt("availableQuantity")));
        }
        return list;
    }

    //to get all students from databse
    public ObservableList<StudentModel> getAllStudents(String tableName) throws SQLException {
        ObservableList<StudentModel> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM `" + tableName + "`";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            list.add(new StudentModel(resultSet.getString("name"),
                    resultSet.getInt("id"),
                    resultSet.getInt("borrowed")));
        }
        return list;
    }

    //to add book to database
    public void addBook(String name, String author, String price, String quantity) throws SQLException {
        String query = "INSERT INTO `books` (name, author, price, quantity, availableQuantity) VALUES ('" + name + "', '" + author + "', '" + price + "', '" + quantity + "', '" + quantity + "')";
        statement.executeUpdate(query);
    }

    //to add student to database
    public void addStudent(String name, String id) throws SQLException {
        String query = "INSERT INTO `students` (name, id, borrowed) VALUES ('" + name + "', '" + id + "', ' 0 ')";
        statement.executeUpdate(query);
    }

    //to search in database by name
    public ResultSet searchName(String nameBook) throws SQLException {
        String query = "SELECT * FROM books WHERE name='" + nameBook + "'";
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    //to updata quantity in database
    public void updateNumberAvailableBook(int newAvalibleQuantity, String nameBook) throws SQLException {
        String newQuery = "UPDATE books SET availableQuantity='" + newAvalibleQuantity + "' WHERE name='" + nameBook + "'";
        statement.executeUpdate(newQuery);

    }

    //to delete row from database by name
    public void deleteRowByName(String nameBook) throws SQLException {
        String query = "DELETE FROM books WHERE name='" + nameBook + "'";
        statement.executeUpdate(query);
    }

}
