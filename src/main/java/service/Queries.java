package service;

import DAO.ActeurDAO;
import DAO.FilmDAO;
import jakarta.persistence.EntityManager;
import model.Acteur;
import model.Film;

import java.util.List;
import java.util.Scanner;

public class Queries {

    public Queries(EntityManager em) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Entrez le nom de l'acteur : ");
                    String nomActeur = scanner.nextLine();
                    List<Acteur> listActeurs = ActeurDAO.getActeursByName(nomActeur, em);
                    List<Film> listFilm = ActeurDAO.getFilmsFromActeurs(listActeurs, em);
                    if (listFilm.isEmpty()) {
                        System.out.println();
                        System.out.println("Aucun film trouvé pour cet acteur : " + nomActeur);
                        System.out.println();
                    } else {
                        System.out.println();
                        System.out.println("******************************************");
                        System.out.println("Filmographie de : " + nomActeur);
                        System.out.println("******************************************");
                        System.out.println();
                        for (Film film : listFilm) {
                            System.out.println(film);
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Entrez le titre du film : ");
                    String titreFilm = scanner.nextLine();
                    List<Film> listFilms = FilmDAO.getFilmByName(titreFilm, em);
                    List<Acteur> castingFilms = ActeurDAO.getActeursFromFilm(listFilms, em);
                    if (castingFilms.isEmpty()) {
                        System.out.println();
                        System.out.println("Aucun film trouvé");
                        System.out.println();
                    } else {
                        System.out.println("******************************************");
                        System.out.println("Casting du film : " + titreFilm);
                        System.out.println("******************************************");
                        System.out.println();
                        for (Acteur acteur : castingFilms) {
                            System.out.println(acteur);
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Entrez l'année de début : ");
                    int anneeDebut = scanner.nextInt();
                    System.out.println("Entrez l'année de fin : ");
                    int anneeFin = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Entrez le nom du premier acteur : ");
                    String premierActeur = scanner.nextLine();
                    System.out.println("Entrez le nom du deuxième acteur : ");
                    String deuxiemeActeur = scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Entrez le titre du premier film : ");
                    String premierFilm = scanner.nextLine();
                    System.out.println("Entrez le titre du deuxième film : ");
                    String deuxiemeFilm = scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Entrez l'année de début : ");
                    int anneeDebut2 = scanner.nextInt();
                    System.out.println("Entrez l'année de fin : ");
                    int anneeFin2 = scanner.nextInt();
                    System.out.println("Entrez le nom de l'acteur/actrice : ");
                    scanner.nextLine();
                    String acteur = scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Fin de l'application.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
            }
        } while (choix != 7);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("Menu :");
        System.out.println("1. Affichage de la filmographie d'un acteur donné");
        System.out.println("2. Affichage du casting d'un film donné");
        System.out.println("3. Affichage des films sortis entre 2 années données");
        System.out.println("4. Affichage des films communs à 2 acteurs/actrices donnés");
        System.out.println("5. Affichage des acteurs communs à 2 films donnés");
        System.out.println("6. Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
        System.out.println("7. Fin de l'application");
        System.out.println("Choisissez une option : ");
    }


}
