package luisquiroz;

import luisquiroz.entities.Catalog;
import luisquiroz.entities.Libro;

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

    public void ricercaElemento(int isbn) {
        listaCatalogo.stream().filter(libro -> libro.getISBN() == isbn).forEach(System.out::println);

    }

    public void ricercaElementoAnno(int anno) {
        listaCatalogo.stream().filter(libro -> libro.getYearPublish() == anno).forEach(System.out::println);
    }

    public void ricercaPerAutore(String autore) {
        
        listaCatalogo.stream().filter(libro -> libro instanceof Libro && ((Libro) libro).getAuthor().equalsIgnoreCase(autore)).forEach(System.out::println);

    }



}
