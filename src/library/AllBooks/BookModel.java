/*
 * book model 
 */
package library.AllBooks;

/**
 *
 * @author mohamedfathidevo
 */
public class BookModel {

    private String bookName;
    private String authorName;
    private double bookPrice;
    private int quantity;
    private int avalibleQuantity;

    public BookModel() {
    }

    public BookModel(String bookName, String authorName, double bookPrice, int quantity, int avalibleQuantity) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.avalibleQuantity = avalibleQuantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvalibleQuantity() {
        return avalibleQuantity;
    }

    public void setAvalibleQuantity(int avalibleQuantity) {
        this.avalibleQuantity = avalibleQuantity;
    }

    

}
