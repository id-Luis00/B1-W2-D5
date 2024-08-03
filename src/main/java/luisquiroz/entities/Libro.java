package luisquiroz.entities;

public class Libro extends Catalog{

    private String author;
    private String genre;


    public Libro(int ISBN, String title, int yearPublish, int numPages, String author, String genre) {
        super(ISBN, title, yearPublish, numPages);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ISBN=" + ISBN +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearPublish=" + yearPublish +
                ", numPages=" + numPages +
                '}';
    }
}
