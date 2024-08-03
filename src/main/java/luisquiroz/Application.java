package luisquiroz;

import com.github.javafaker.Faker;
import luisquiroz.entities.Catalog;
import luisquiroz.entities.Libro;
import luisquiroz.entities.Rivista;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class Application {

    public static final Logger logger = LoggerFactory.getLogger(Application.class);
    public static final Scanner scanner = new Scanner(System.in);
    public static final Faker faker = new Faker();

    public static void main(String[] args) {

        Archivio listaCatalogo = new Archivio();
        int scelta = 100;

        listaCatalogo.addToCatalog(new Libro(1, faker.leagueOfLegends().champion(), 2000, 100, "Me", faker.leagueOfLegends().location()));
        listaCatalogo.addToCatalog(new Libro(1234, "qdfq", 14234, 123, "asdaw", "aiuwhdiau"));
        listaCatalogo.addToCatalog(new Rivista(1287, "aujwyg", 2000, 20, Periodicita.MENSILE));

        while (true) {

            System.out.println("\ncosa vuoi fare?" +
                    "\n1 - Aggiungere un libro/rivista" +
                    "\n2 - rimuovere un elemento tramite ISBN" +
                    "\n3 - ricerca tramite ISBN" +
                    "\n4 - ricerca per anno di pubblicazione" +
                    "\n5 - ricerca per autore" +
                    "\n6 - salvataggio su disco dell'archivio" +
                    "\n7 - caricamento dal disco dell'archivio in una nuova lista");

            try {
                scelta = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Devi inserire un numero!! Riprova.");
            }
            switch (scelta) {
                case 1:
                    System.out.println("cosa vuoi inserire?\n1- un libro\n2- una rivista");

                    try {
                        scelta = 100;
                        scelta = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("1 o 2: sono queste le scelte possibili, riprova.");
                    }

                    switch (scelta) {

                        case 1:
                            try {
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
                            } catch (NumberFormatException e) {
                                System.out.println("Formato non valido, inserire un numero " + "\nMessaggio di errore --> " + e.getMessage());
                            } catch (Exception e) {
                                System.out.println("è stato riscontrato un errore " + e.getMessage());
                            }


                            break;
                        case 2:
                            try {
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

                            } catch (NumberFormatException e) {
                                System.out.println("Formato non valido, inserire un numero " + "\nMessaggio di errore --> " + e.getMessage());
                            } catch (Exception e) {
                                System.out.println("è stato riscontrato un errore " + "\nMessaggio di errore --> " + e.getMessage());
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("quale elemento vuoi eliminare? (devi inserire l'ISBN) ");
                    listaCatalogo.stampaCatalogo();
                    int risposta = Integer.parseInt(scanner.nextLine());
                    listaCatalogo.rimuoviElemento(risposta);
                    break;
                case 3:
                    System.out.println("inserisci l'ISBN del libro/rivista: ");
                    try {
                        int isbn = Integer.parseInt(scanner.nextLine());
                        listaCatalogo.ricercaElemento(isbn);
                    } catch (Exception e) {
                        System.out.println("Errore --> " + e.getMessage());
                    }

                    break;
                case 4:
                    System.out.println("inserisci l'anno di pubblicazione: ");
                    try {
                        int anno = Integer.parseInt(scanner.nextLine());
                        listaCatalogo.ricercaElementoAnno(anno);
                    }catch (Exception e) {
                        System.out.println("Errore --> " + e.getMessage());
                    }

                    break;
                case 5:
                    System.out.println("inserisci l'autore: ");
                    String autore = scanner.nextLine();
                    listaCatalogo.ricercaPerAutore(autore);
                    break;
                default:
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



