package luisquiroz;

import luisquiroz.entities.Catalog;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    // classe dove aggiungerò tutti i metodi che mi servono

    private List<Catalog> listaCatalogo = new ArrayList<>();

    public void addToCatalog(Catalog book) {
        this.listaCatalogo.add(book);
    }

    public void stampaCatalogo() {
        listaCatalogo.forEach(System.out::println);
    }

    public List<Catalog> getListaCatalogo() {
        return listaCatalogo;
    }

    @Override
    public String toString() {
        return "Archivio{" +
                "listaCatalogo=" + listaCatalogo +
                '}';
    }
}
