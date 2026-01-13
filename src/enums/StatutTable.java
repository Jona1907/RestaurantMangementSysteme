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


    @Override
    public String toString() {
        return libelle;
    }
}
