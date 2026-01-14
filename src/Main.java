import enums.CategorieMenu;
import models.ArticleMenu;
import models.Commande;
import models.Table;
import services.RestaurantService;

public class Main {

    public static void main(String[] args) throws Exception {

        RestaurantService restaurant = new RestaurantService();

        // Création des tables
        restaurant.ajouterTable(new Table(1, 2));
        restaurant.ajouterTable(new Table(2, 4));

        // Installer clients
        Table table = restaurant.trouverTableLibre(2);
        Commande commande = restaurant.installerClients(table);

        // Articles
        ArticleMenu pizza = new ArticleMenu(1, "Pizza", 8.5, CategorieMenu.PLAT);
        ArticleMenu eau = new ArticleMenu(2, "Eau", 1.5, CategorieMenu.BOISSON);

        commande.ajouterArticle(pizza);
        commande.ajouterArticle(eau);

        // Affichage
        restaurant.afficherEtatRestaurant();

        // Libérer table
        restaurant.libererTable(table);

        restaurant.afficherEtatRestaurant();
    }
}
