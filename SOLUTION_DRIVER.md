# 🔧 SOLUTION - Ajouter le driver MySQL

## ⚠️ Problème
Le driver MySQL n'est pas trouvé : `Class [com.mysql.jdbc.Driver] not found`

## ✅ Solution en 3 étapes

### Étape 1 : Télécharger le driver MySQL

**Lien direct de téléchargement** :
https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.2.0/mysql-connector-j-8.2.0.jar

1. Cliquez sur le lien ci-dessus
2. Le fichier `mysql-connector-j-8.2.0.jar` sera téléchargé
3. Enregistrez-le sur votre Bureau ou dans Téléchargements

---

### Étape 2 : Ajouter le driver dans NetBeans

1. Dans NetBeans, **clic droit** sur le projet **JSF1BD**
2. Cliquez sur **Properties** (Propriétés)
3. Dans le menu de gauche, cliquez sur **Libraries**
4. Cliquez sur le bouton **"Add JAR/Folder..."**
5. Naviguez vers le fichier `mysql-connector-j-8.2.0.jar` que vous avez téléchargé
6. Sélectionnez-le et cliquez sur **"Open"**
7. Cliquez sur **"OK"**

---

### Étape 3 : Vérifier et redéployer

1. Dans NetBeans, développez votre projet **JSF1BD**
2. Développez **Libraries**
3. Vérifiez que `mysql-connector-j-8.2.0.jar` apparaît dans la liste ✅

4. **Clean and Build** le projet :
   - Clic droit sur le projet → **Clean and Build** (Shift+F11)

5. **Run** le projet :
   - Clic droit sur le projet → **Run** (F6)

---

## 🎯 Après avoir ajouté le driver

1. Le formulaire devrait s'afficher sans erreur
2. Remplissez les champs (code, description, quantité, prix)
3. Cliquez sur **"Insertion"**
4. Un message de succès devrait s'afficher
5. Vérifiez dans phpMyAdmin que le produit est bien inséré

---

## ✅ Checklist finale

- [ ] Driver MySQL téléchargé
- [ ] Driver ajouté dans Libraries du projet
- [ ] Driver visible dans l'arborescence Libraries
- [ ] Clean and Build réussi
- [ ] Application déployée
- [ ] Formulaire accessible
- [ ] Insertion testée
- [ ] Produit visible dans phpMyAdmin

---

**C'est tout ! Une fois le driver ajouté, tout fonctionnera ! 🚀**
