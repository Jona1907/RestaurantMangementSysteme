package models;

import enums.StatutTable;
import exceptions.CommandeException;
import interfaces.Affichable;

/**
 * Représente une table du restaurant.
 */
public class Table implements Affichable {

    private int numero;
    private int capacite;
    private StatutTable statut;
    private Commande commande;

    public Table(int numero, int capacite) {
        this.numero = numero;
        this.capacite = capacite;
        this.statut = StatutTable.LIBRE;
        this.commande = null;
    }

    // =====================
    // STATUT
    // =====================

    public void changerStatut(StatutTable nouveauStatut)
            throws CommandeException {

        if (!statut.peutPasserA(nouveauStatut)) {
            throw new CommandeException(
                    "Transition de statut invalide : " + statut + " → " + nouveauStatut
            );
        }
        statut = nouveauStatut;
    }

    // =====================
    // COMMANDE
    // =====================

    public void ouvrirCommande(Commande commande) throws CommandeException {
        if (statut != StatutTable.OCCUPEE) {
            throw new CommandeException(
                    "Impossible d'ouvrir une commande : la table n'est pas occupée."
            );
        }
        this.commande = commande;
    }

    public void fermerCommande() {
        this.commande = null;
    }

    public boolean estLibre() {
        return statut == StatutTable.LIBRE;
    }

    public int getCapacite() {
        return capacite;
    }


    // =====================
    // AFFICHAGE
    // =====================

    @Override
    public void afficher() {
        System.out.println("Table n°" + numero);
        System.out.println("Capacité : " + capacite);
        System.out.println("Statut : " + statut);

        if (commande != null) {
            System.out.println("Commande associée : ");
            commande.afficher();
        }
    }
}
