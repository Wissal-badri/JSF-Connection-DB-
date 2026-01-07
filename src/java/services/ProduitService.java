package services;

import entities.Produit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProduitService {

    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("JSF1BDPU");
        } catch (Exception e) {
            System.err.println("Erreur lors de la création de l'EntityManagerFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insererProduit(Produit produit) throws Exception {
        if (emf == null) {
            throw new Exception(
                    "EntityManagerFactory n'est pas initialisé. Vérifiez persistence.xml et la connexion à la base de données.");
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(produit);
            em.getTransaction().commit();
            System.out.println("Produit inséré avec succès: " + produit);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erreur lors de l'insertion du produit: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Impossible d'insérer le produit: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Produit rechercherProduit(String code) {
        if (emf == null) {
            System.err.println("EntityManagerFactory n'est pas initialisé.");
            return null;
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.find(Produit.class, code);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public java.util.List<Produit> findAll() {
        if (emf == null) {
            System.err.println("EntityManagerFactory n'est pas initialisé.");
            return new java.util.ArrayList<>();
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des produits: " + e.getMessage());
            return new java.util.ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void fermerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
