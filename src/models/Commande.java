package models;

import enums.StatutCommande;
import exceptions.CommandeException;
import interfaces.Affichable;
import interfaces.Calculable;
import interfaces.Payable;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une commande dans le restaurant.
 */

public class Commande implements Calculable, Affichable, Payable {

    private int id;
    private List<ArticleMenu> articles;
    private StatutCommande statut;
    private boolean payee;

    public Commande(int id) {
        this.id = id;
        this.articles = new ArrayList<>();
        this.statut = StatutCommande.EN_ATTENTE;
        this.payee = false;
    }

    // ==========================
    // GESTION DES ARTICLES
    // ==========================

    public void ajouterArticle(ArticleMenu article) throws CommandeException {
        if (statut != StatutCommande.EN_ATTENTE) {
            throw new CommandeException(
                    "Impossible d'ajouter un article : la commande n'est plus en attente."
            );
        }
        articles.add(article);
    }

    // ==========================
    // STATUT
    // ==========================
    public void changerStatut(StatutCommande nouveauStatut) throws CommandeException{
        if(!statut.peutPasserA(nouveauStatut)){
            throw new CommandeException(
                    "Transition de statut invalide : " + statut + " -> " + nouveauStatut
            );
        }
        this.statut = nouveauStatut;
    }

    // ==========================
    // CALCUL
    // ==========================
    @Override
    public double calculerTotal() {
        double total = 0;
        for (ArticleMenu a : articles) {
            total += a.getPrix();
        }
        return total;
    }

    // ==========================
    // PAIEMENT
    // ==========================

    @Override
    public void payer() {
        if (payee) {
            return;
        }
        payee = true;
        statut = StatutCommande.PAYEE;
    }

    // ==========================
    // AFFICHAGE
    // ==========================

    @Override
    public void afficher() {
        System.out.println("Commande #" + id);
        System.out.println("Statut : " + statut);
        System.out.println("Articles :");

        for (ArticleMenu a : articles) {
            System.out.println("- " + a.getNom() + " : " + a.getPrix() + " €");
        }

        System.out.println("TOTAL : " + calculerTotal() + " €");
    }
}

