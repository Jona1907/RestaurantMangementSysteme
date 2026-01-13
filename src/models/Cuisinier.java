package models;

/**
 * Représente un cuisinier du restaurant.
 */
public class Cuisinier extends Personne{
    public Cuisinier(int id, String nom){
        super(id, nom);
    }

    @Override
    public String getRole(){
        return "Cuisiner";
    }

}
