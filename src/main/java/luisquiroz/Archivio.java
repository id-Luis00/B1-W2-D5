package luisquiroz;

import luisquiroz.entities.Catalog;
import luisquiroz.entities.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Archivio {



    // classe dove aggiungerò tutti i metodi che mi servono

    private final List<Catalog> listaCatalogo = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Archivio.class);

    public void addToCatalog(Catalog element) {
        if (element != null) {
            this.listaCatalogo.add(element);
            logger.info("Elemento aggiunto al catalogo: " + element + "\n");
        } else {
            logger.warn("Non puoi inserire un elemento vuoto");
        }
    }

    public void stampaCatalogo() {
        final int[] index = {1};

        if(listaCatalogo.isEmpty()) {
            System.out.println("il catalogo è vuoto");
        } else {
            listaCatalogo.forEach(elemento -> {
                System.out.println(index[0] + " - " + elemento);
                index[0]++;
            });
        }


    }

    public void rimuoviElemento(int isbn) {
        boolean removed = listaCatalogo.removeIf(element -> element.getISBN() == isbn);
        if (removed) {
            System.out.println("Elemento rimosso. Lista aggiornata:");
            stampaCatalogo();
        } else {
            System.out.println("Elemento non trovato con ISBN: " + isbn);
        }
    }

    public void ricercaElemento(int isbn) {
        listaCatalogo.stream()
                .filter(libro -> libro.getISBN() == isbn)
                .forEach(System.out::println);

    }

    public void ricercaElementoAnno(int anno) {
        listaCatalogo.stream()
                .filter(libro -> libro.getYearPublish() == anno)
                .forEach(System.out::println);
    }

    public void ricercaPerAutore(String autore) {

        listaCatalogo
                .stream()
                .filter(libro -> libro instanceof Libro && ((Libro) libro).getAuthor().equalsIgnoreCase(autore))
                .forEach(System.out::println);

    }

    public void clearCatalog() {
        listaCatalogo.clear();
        logger.info("Elementi eliminati con successo");


    }



}
