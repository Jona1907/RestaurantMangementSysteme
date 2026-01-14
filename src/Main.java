import enums.CategorieMenu;
import enums.StatutCommande;
import models.ArticleMenu;
import models.Commande;

public class Main {

    public static void main(String[] args) throws Exception {

        ArticleMenu pizza = new ArticleMenu(1, "Pizza", 8.5, CategorieMenu.PLAT);
        ArticleMenu cola = new ArticleMenu(2, "Cola", 2.5, CategorieMenu.BOISSON);

        Commande commande = new Commande(1);

        commande.ajouterArticle(pizza);
        commande.ajouterArticle(cola);

        commande.afficher();

        commande.changerStatut(StatutCommande.EN_PREPARATION);
        commande.changerStatut(StatutCommande.PRETE);
        commande.changerStatut(StatutCommande.SERVIE);

        commande.payer();

        commande.afficher();
    }
}
