package luisquiroz.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return ISBN == catalog.ISBN && yearPublish == catalog.yearPublish && numPages == catalog.numPages && Objects.equals(title, catalog.title);
    }


}
