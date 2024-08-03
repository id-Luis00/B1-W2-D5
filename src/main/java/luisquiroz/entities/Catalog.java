package luisquiroz.entities;

public abstract class Catalog {
    protected int ISBN;
    protected String title;
    protected int yearPublish;
    protected int numPages;

    public Catalog(int ISBN, String title, int yearPublish, int numPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublish = yearPublish;
        this.numPages = numPages;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public int getNumPages() {
        return numPages;
    }


}
