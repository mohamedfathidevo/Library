/*
 * student model
 */
package library.AllStudents;

/**
 *
 * @author mohamedfathidevo
 */
public class StudentModel {

    private String name;
    private int ID;
    private int numberOfBook;

    public StudentModel() {
    }

    public StudentModel(String name, int ID, int numberOfBook) {
        this.name = name;
        this.ID = ID;
        this.numberOfBook = numberOfBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

}
