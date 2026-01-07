# Projet JSF - Insertion de Produits

## Description
Ce projet JSF permet d'insérer des produits dans une base de données MySQL nommée `db_j2ee`.

## Structure du projet

### 1. Base de données
- **Nom de la base**: `db_j2ee`
- **Table**: `produit`
- **Colonnes**:
  - `code` (VARCHAR(50), PRIMARY KEY)
  - `description` (VARCHAR(255))
  - `quantite` (INT)
  - `prix` (DECIMAL(10,2))

### 2. Fichiers créés

#### Entités et Services
- `src/java/entities/Produit.java` - Entité JPA
- `src/java/services/ProduitService.java` - Service pour gérer les opérations BD
- `src/java/beans/ProduitBean.java` - Managed Bean JSF

#### Configuration
- `src/conf/persistence.xml` - Configuration JPA
- `web/WEB-INF/web.xml` - Configuration JSF (déjà existant)

#### Interface
- `web/index.xhtml` - Formulaire d'insertion (sans CSS)

#### Base de données
- `database_script.sql` - Script pour créer la table

## Instructions d'installation

### 1. Créer la table dans la base de données

Exécutez le script SQL suivant dans MySQL:

```sql
USE db_j2ee;

CREATE TABLE IF NOT EXISTS produit (
    code VARCHAR(50) PRIMARY KEY,
    description VARCHAR(255),
    quantite INT,
    prix DECIMAL(10, 2)
);
```

### 2. Vérifier la configuration de la base de données

Dans le fichier `src/conf/persistence.xml`, vérifiez que les paramètres de connexion sont corrects:
- URL: `jdbc:mysql://localhost:3306/db_j2ee`
- Utilisateur: `root`
- Mot de passe: (vide par défaut, modifiez si nécessaire)

### 3. Ajouter les bibliothèques nécessaires

Assurez-vous que votre projet contient les bibliothèques suivantes:
- **MySQL Connector/J** (pour la connexion MySQL)
- **EclipseLink** ou **Hibernate** (pour JPA)
- **JSF 2.x** (normalement inclus dans le serveur d'application)

Dans NetBeans:
1. Clic droit sur le projet → Properties
2. Libraries → Add Library
3. Ajouter: MySQL JDBC Driver, EclipseLink (JPA 2.1)

### 4. Déployer et exécuter

1. Clic droit sur le projet → Clean and Build
2. Clic droit sur le projet → Run
3. L'application s'ouvrira dans votre navigateur à l'adresse: `http://localhost:8080/JSF1BD/`

## Utilisation

1. Remplissez le formulaire avec:
   - **Code**: Code unique du produit
   - **Description**: Description du produit
   - **Quantité**: Quantité en stock
   - **Prix**: Prix du produit

2. Cliquez sur le bouton **Insertion**

3. Un message de succès ou d'erreur s'affichera

## Dépannage

### Erreur de connexion à la base de données
- Vérifiez que MySQL est démarré
- Vérifiez que la base de données `db_j2ee` existe
- Vérifiez les identifiants dans `persistence.xml`

### Erreur "ClassNotFoundException: com.mysql.jdbc.Driver"
- Ajoutez la bibliothèque MySQL Connector/J au projet

### Le formulaire ne s'affiche pas
- Vérifiez que JSF est correctement configuré dans `web.xml`
- Vérifiez l'URL: `http://localhost:8080/JSF1BD/faces/index.xhtml`
