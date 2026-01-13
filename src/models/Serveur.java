package models;

/**
 * Représente un serveur du restaurant.
 */
public class Serveur extends Personne{
    public Serveur(int id, String nom){
        super(id, nom);
    }

    @Override
    public String getRole(){
        return "Serveur";
    }

}
