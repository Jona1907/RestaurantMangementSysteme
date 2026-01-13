package enums;

/**
 * Enumeration gerer l'etat d'une table
 */
public enum StatutTable {

    LIBRE("Libre"),
    OCCUPEE("Occupée"),
    RESERVEE("Reservée");

    private final String libelle;

    StatutTable(String libelle){
        this.libelle = libelle;
    }

    public String getLibelle(){
        return libelle;
    }

    /**
     * Verifie si la table peut changer de statut
     */

    public boolean peutPasserA(StatutTable nouveauStatut){
        switch (this){
            case LIBRE:
                return nouveauStatut == OCCUPEE || nouveauStatut == RESERVEE;

            case RESERVEE:
                return nouveauStatut == OCCUPEE;

            case OCCUPEE:
                return nouveauStatut == LIBRE;

            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return libelle;
    }
}
