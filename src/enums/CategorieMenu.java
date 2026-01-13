package enums;

/**
 * Enumeration representant les differentes categories d'articles du menu
 */

public enum CategorieMenu {

    ENTREE("Entrée"),
    PLAT("Plat Principal"),
    DESSERT("Dessert"),
    BOISSON("Boisson");

    // =====================
    // ATTRIBUT
    // =====================
    private final String nomAffiche;

    // =====================
    // CONSTRUCTEUR
    // =====================
    CategorieMenu(String nomAffiche) {
        this.nomAffiche = nomAffiche;
    }

    // =====================
    // GETTER
    // =====================
    public String getNomAffiche() {
        return nomAffiche;
    }

    // =====================
    // AFFICHE
    // =====================
    @Override
    public String toString() {
        return nomAffiche;
    }

}
