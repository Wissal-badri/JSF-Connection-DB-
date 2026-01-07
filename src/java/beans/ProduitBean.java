package beans;

import entities.Produit;
import services.ProduitService;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "produitBean")
@SessionScoped
public class ProduitBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private Integer quantite;
    private BigDecimal prix;

    // Nouvelle liste pour stocker les produits
    private java.util.List<Produit> listeProduits;

    private ProduitService produitService;

    public ProduitBean() {
        produitService = new ProduitService();
        listeProduits = new java.util.ArrayList<>();
        System.out.println("ProduitBean initialisé");
        // Initialiser la liste au démarrage
        listerProduits();
    }

    // Méthode appelée par le bouton "Lister"
    public String listerProduits() {
        listeProduits = produitService.findAll();
        System.out.println("Liste rechargée : " + (listeProduits != null ? listeProduits.size() : "null"));
        return null; // Reste sur la même page
    }

    // Getter pour la liste
    public java.util.List<Produit> getListeProduits() {
        return listeProduits;
    }

    public String insererProduit() {
        System.out.println("Tentative d'insertion du produit...");
        System.out.println("Code: " + code);
        System.out.println("Description: " + description);
        System.out.println("Quantité: " + quantite);
        System.out.println("Prix: " + prix);

        try {
            // Validation basique
            if (code == null || code.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erreur", "Le code est obligatoire"));
                return null;
            }

            if (description == null || description.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erreur", "La description est obligatoire"));
                return null;
            }

            if (quantite == null || quantite < 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erreur", "La quantité doit être un nombre positif"));
                return null;
            }

            if (prix == null || prix.compareTo(BigDecimal.ZERO) < 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Erreur", "Le prix doit être un nombre positif"));
                return null;
            }

            // Créer et insérer le produit
            Produit produit = new Produit(code, description, quantite, prix);
            produitService.insererProduit(produit);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Succès", "Produit inséré avec succès!"));

            // Keep messages for the redirect
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            // Réinitialiser les champs
            code = null;
            description = null;
            quantite = null;
            prix = null;

            System.out.println("Produit inséré avec succès!");

            // Refresh the list
            listerProduits();

            return "index?faces-redirect=true";

        } catch (Exception e) {
            System.err.println("Erreur lors de l'insertion: " + e.getMessage());
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erreur", "Erreur lors de l'insertion: " + e.getMessage()));
            return null;
        }
    }

    // Getters et Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}
