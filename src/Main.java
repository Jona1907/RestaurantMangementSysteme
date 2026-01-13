import models.Cuisinier;
import models.Personne;
import models.Serveur;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Personne p1 = new Serveur(1,"Ali");
        Personne p2 = new Cuisinier(2, "Fatima");

        p1.afficher();
        System.out.println("--------------------");
        p2.afficher();

    }
}