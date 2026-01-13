package models;

/**
 * Classe abstraite représentant une personne du restaurant.
 */
public abstract class Personne {

    protected int id;
    protected String nom;

    public Personne(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    /**
     * Méthode abstraite que chaque personne doit implémenter.
     */

    public abstract String getRole();

        /**
         * Méthode concrète partagée.
         */
    public void afficher(){
        System.out.println("ID: " + id);
        System.out.println("Nom: " + nom);
        System.out.println("Role: " + getRole());

    }

}
