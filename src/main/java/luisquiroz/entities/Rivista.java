package luisquiroz.entities;

import luisquiroz.Periodicita;

public class Rivista extends Catalog {

    private Periodicita periodicita;

    public Rivista(int ISBN, String title, int yearPublish, int numPages, Periodicita periodicita) {
        super(ISBN, title, yearPublish, numPages);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", yearPublish=" + yearPublish +
                ", numPages=" + numPages +
                '}';
    }
}
