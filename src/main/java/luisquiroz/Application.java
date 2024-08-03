package luisquiroz;

import luisquiroz.entities.Catalog;
import luisquiroz.entities.Libro;
import luisquiroz.entities.Rivista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Archivio listaCatalogo = new Archivio();

        Libro primo = new Libro(1, "presentazione", 2000, 100, "Me", "Biografico");

        while (true) {

            System.out.println("\ncosa vuoi fare?" +
                    "\n1 - Aggiungere un libro/rivista" +
                    "\n2 - rimuovere un elemento tramite ISBN" +
                    "\n3 - ricerca tramite ISBN" +
                    "\n4 - ricerca per anno di pubblicazione" +
                    "\n5 - ricerca per autore" +
                    "\n6 - salvataggio su disco dell'archivio" +
                    "\7 - caricamento dal disco dell'archivio in una nuova lista");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.println("cosa vuoi inserire?\n1- un libro\n2- una rivista");
                    String risp = scanner.nextLine();
                    switch (Integer.parseInt(risp)) {
                        case 1:
                            System.out.println("inserisci isbn:");
                            int bookIsbn = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci titolo: ");
                            String bookTitle = scanner.nextLine();
                            System.out.println("inserisci anno: ");
                            int bookYear = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci pagine: ");
                            int bookPages = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci autore: ");
                            String bookAuthor = scanner.nextLine();
                            System.out.println("inserisci genere: ");
                            String bookGenre = scanner.nextLine();

                            Libro libro = new Libro(bookIsbn, bookTitle, bookYear, bookPages, bookAuthor, bookGenre);
                            listaCatalogo.addToCatalog(libro);

                            listaCatalogo.stampaCatalogo();

                            break;
                        case 2:
                            System.out.println("inserisci isbn:");
                            int magIsbn = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci titolo: ");
                            String magTitle = scanner.nextLine();
                            System.out.println("inserisci anno: ");
                            int magYear = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci pagine: ");
                            int magPages = Integer.parseInt(scanner.nextLine());
                            System.out.println("inserisci periodocità (MENSILE, SEMESTRALE, SETTIMANALE): ");
                            Periodicita periodicita = Periodicita.valueOf(scanner.nextLine());

                            Rivista rivista = new Rivista(magIsbn, magTitle, magYear, magPages, periodicita);
                            listaCatalogo.addToCatalog(rivista);

                            listaCatalogo.stampaCatalogo();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("niente");
                    break;
            }


        }


    /*

    Esercizi da fare:
       - aggiungere un elemento
       - rimuovere un elemento tramite ISBN
       - ricerca tramite ISBN
       - ricerca per anno di pubblicazione
       - ricerca per autore
       - salvataggio su disco dell'archivio
       - caricamento dal disco dell'archivio in una nuova lista

    */

    }
}


