package services;

import enums.StatutTable;
import exceptions.CommandeException;
import models.Commande;
import models.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Service central de gestion du restaurant.
 */
public class RestaurantService {

    private List<Table> tables;
    private int prochaineCommandeId;

    public RestaurantService() {
        this.tables = new ArrayList<>();
        this.prochaineCommandeId = 1;
    }

    // =====================
    // GESTION DES TABLES
    // =====================

    public void ajouterTable(Table table) {
        tables.add(table);
    }

    public Table trouverTableLibre(int capaciteMin) {
        for (Table table : tables) {
            if (table != null && table.estLibre() && table.getCapacite() >= capaciteMin) {
                return table;
            }
        }
        return null;
    }

    // =====================
    // GESTION DES COMMANDES
    // =====================

    public Commande installerClients(Table table) throws CommandeException {

        if (table == null) {
            throw new CommandeException("Aucune table disponible.");
        }

        table.changerStatut(StatutTable.OCCUPEE);

        Commande commande = new Commande(prochaineCommandeId++);
        table.ouvrirCommande(commande);

        return commande;
    }

    public void libererTable(Table table) throws CommandeException {

        if (table == null) {
            return;
        }

        table.fermerCommande();
        table.changerStatut(StatutTable.LIBRE);
    }

    // =====================
    // AFFICHAGE
    // =====================

    public void afficherEtatRestaurant() {
        for (Table table : tables) {
            table.afficher();
            System.out.println("--------------------");
        }
    }
}
