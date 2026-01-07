package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code", length = 50)
    private String code;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "prix", precision = 10, scale = 2)
    private BigDecimal prix;

    public Produit() {
    }

    public Produit(String code, String description, Integer quantite, BigDecimal prix) {
        this.code = code;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }

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

    @Override
    public String toString() {
        return "Produit{" + "code=" + code + ", description=" + description + ", quantite=" + quantite + ", prix="
                + prix + '}';
    }
}
