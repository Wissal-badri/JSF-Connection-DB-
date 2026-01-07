package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe de test pour vérifier la connexion à la base de données
 */
public class TestConnexion {

    public static void main(String[] args) {
        System.out.println("=== Test de connexion à la base de données ===");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            System.out.println("1. Création de l'EntityManagerFactory...");
            emf = Persistence.createEntityManagerFactory("JSF1BDPU");
            System.out.println("✅ EntityManagerFactory créé avec succès !");

            System.out.println("2. Création de l'EntityManager...");
            em = emf.createEntityManager();
            System.out.println("✅ EntityManager créé avec succès !");

            System.out.println("3. Test de connexion...");
            em.getTransaction().begin();
            System.out.println("✅ Transaction démarrée !");

            em.getTransaction().commit();
            System.out.println("✅ Transaction validée !");

            System.out.println("\n🎉 CONNEXION RÉUSSIE ! La base de données est accessible.");

        } catch (Exception e) {
            System.err.println("\n❌ ERREUR DE CONNEXION !");
            System.err.println("Message d'erreur : " + e.getMessage());
            System.err.println("\nDétails de l'erreur :");
            e.printStackTrace();

            System.err.println("\n📋 Vérifications à faire :");
            System.err.println("1. MySQL est-il démarré dans XAMPP ?");
            System.err.println("2. La base de données 'bd_j2ee' existe-t-elle ?");
            System.err.println("3. Le driver MySQL est-il ajouté dans les bibliothèques ?");
            System.err.println("4. Les identifiants dans persistence.xml sont-ils corrects ?");

        } finally {
            if (em != null && em.isOpen()) {
                em.close();
                System.out.println("EntityManager fermé.");
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
                System.out.println("EntityManagerFactory fermé.");
            }
        }

        System.out.println("\n=== Fin du test ===");
    }
}
