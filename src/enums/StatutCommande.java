package enums;

/**
 * Enumeration representant les statuts possible d'une commande
 */
public enum StatutCommande {

    EN_ATTENTE("En attente", 1),
    EN_PREPARATION("En preparation", 2),
    PRETE("Prete", 3),
    SERVIE("Servie", 4),
    PAYEE("Payée", 5),
    ANNULEE("Annulée", -1);

    // =====================
    // ATTRIBUT
    // =====================
    private final String libelle;
    private final int ordre;

    // =====================
    // CONSTRUCTEUR
    // =====================
    StatutCommande(String libelle, int ordre) {
        this.libelle = libelle;
        this.ordre = ordre;
    }

    // =====================
    // GETTER
    // =====================

    public String getLibelle() {
        return libelle;
    }

    public int getOrdre() {
        return ordre;
    }

    // =====================
    // METHODES METIER
    // =====================
    public boolean peutPasserA(StatutCommande nouveauStatut){
        if(nouveauStatut==ANNULEE){
            return this != PAYEE;
        }
        return nouveauStatut.ordre == this.ordre + 1;
    }

    public boolean estTerminee(){
        return this == SERVIE || this == PAYEE;
    }

    @Override
    public String toString(){
        return libelle;
    }
}
