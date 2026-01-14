package enums;

/**
 * Représente l'état d'une table dans le restaurant.
 */
public enum StatutTable {

    LIBRE,
    RESERVEE,
    OCCUPEE;

    /**
     * Vérifie si la transition vers un nouveau statut est autorisée.
     */
    public boolean peutPasserA(StatutTable nouveauStatut) {

        switch (this) {

            case LIBRE:
                return nouveauStatut == RESERVEE || nouveauStatut == OCCUPEE;

            case RESERVEE:
                return nouveauStatut == OCCUPEE;

            case OCCUPEE:
                return nouveauStatut == LIBRE;

            default:
                return false;
        }
    }
}
