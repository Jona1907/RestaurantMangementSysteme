import enums.*;

public class TestEnums {

    public static void main(String[] Args){
        System.out.println("=== TEST DES ENUMS ===");

        for (CategorieMenu c : CategorieMenu.values()){
            System.out.println(c);
        }

        System.out.println("\n=== STATUT COMMANDE ===");

        StatutCommande statut = StatutCommande.EN_ATTENTE;
        System.out.println("Statut actuelle: " + statut);
        System.out.println("Peut passer a EN_PREPARATION ? " +
                statut.peutPasserA(StatutCommande.EN_PREPARATION));

        System.out.println(statut.getOrdre());
        System.out.println(StatutCommande.EN_PREPARATION.getOrdre());

    }
}
