package luisquiroz;

import luisquiroz.entities.Catalog;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    // classe dove aggiungerò tutti i metodi che mi servono

    private final List<Catalog> listaCatalogo = new ArrayList<>();

    public void addToCatalog(Catalog book) {
        this.listaCatalogo.add(book);
    }

    public void stampaCatalogo() {
        final int[] index = {1};

        listaCatalogo.forEach(elemento -> {
            System.out.println(index[0] + " - " + elemento);
            index[0]++;
        });
    }

    public void rimuoviElemento(int isbn) {
        listaCatalogo.removeIf(libro -> libro.getISBN() == isbn);
        System.out.println("lista aggiornata");
        stampaCatalogo();
    }
    


}
