package models;

import enums.CategorieMenu;
import interfaces.Affichable;

/**
 * Représente un article du menu du restaurant.
 */
public class ArticleMenu implements Affichable{

    private int id;
    private String nom;
    private double prix;
    private CategorieMenu categorie;

    public ArticleMenu(int id, String nom, double prix, CategorieMenu categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public CategorieMenu getCategorie() {
        return categorie;
    }

    @Override
    public void afficher() {
        System.out.println("ID: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Prix: " + prix + " Euro");
        System.out.println("Categorie: " + categorie);
    }
}
