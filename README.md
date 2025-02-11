Système de Gestion Bancaire en Java

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Swing](https://img.shields.io/badge/GUI-Swing-orange)

Un système de gestion bancaire simple et intuitif développé en Java avec une interface graphique (Swing). Ce projet permet aux utilisateurs de gérer des comptes bancaires, d'effectuer des opérations de base, et de naviguer facilement entre les fonctionnalités.

---

Fonctionnalités

- **Création de compte** : Créez un nouveau compte bancaire avec un prénom, un nom, un mot de passe et un solde initial.
- **Connexion** : Connectez-vous à un compte existant en utilisant un identifiant et un mot de passe.
- **Dépôts et retraits** : Effectuez des dépôts et des retraits en toute sécurité.
- **Consultation du solde** : Consultez le solde de votre compte à tout moment.
- **Virements** : Transférez des fonds entre comptes de manière sécurisée.
- **Déconnexion** : Déconnectez-vous pour vous connecter à un autre compte.

---

Structure du Projet

Arborescence des Fichiers

~~~plaintext
├── 📁 code/
│   ├── 📄 .gitignore
│   ├── 📁 .idea/
│   │   ├── 📄 .gitignore
│   │   ├── 📄 .name
│   │   └── ... # Fichiers de configuration IntelliJ
│   ├── 📄 Test.iml
│   └── 📁 src/
│       └── 📁 SystemeDeGestionBancaire/
│           ├── 📄 BaseDeDonnees.java   # Gestion de la base de données
│           ├── 📄 Compte.java          # Modèle de compte bancaire
│           ├── 📄 Connexion.java       # Interface de connexion utilisateur
│           ├── 📄 CreerCompte.java     # Création d'un nouveau compte
│           ├── 📄 Depot.java           # Gestion des dépôts d'argent
│           ├── 📄 Main.java            # Point d'entrée de l'application
│           ├── 📄 Menu.java            # Menu principal des opérations bancaires
│           ├── 📄 Retrait.java         # Gestion des retraits d'argent
│           └── 📄 Virement.java        # Gestion des virements entre comptes
└── 📁 docs/
    └── 📄 Rapport du projet java.pdf   # Documentation complète
~~~

---

Comment Utiliser

1. **Clonez le dépôt** :
   ```bash
   git clone https://github.com/MohammedAbd01/Application_de_gestion_bancaire
   ```
2. **Ouvrez le projet** dans votre IDE préféré (Eclipse, IntelliJ, etc.).
3. **Compilez et exécutez** le fichier `Main.java` pour lancer l'application.
4. Suivez les instructions à l'écran pour créer un compte, vous connecter, et effectuer des opérations bancaires.

---

 Captures d'Écran

Écran de Connexion
![Écran de connexion](https://github.com/MohammedAbd01/Application_de_gestion_bancaire/blob/main/Sc/Sc1.png)

Menu de Création de Compte
![Menu principal](https://github.com/MohammedAbd01/Application_de_gestion_bancaire/blob/main/Sc/Sc2.png)

Interface d'Opérations Bancaires
![Interface d'Opérations Bancaires](https://github.com/MohammedAbd01/Application_de_gestion_bancaire/blob/main/Sc/Sc3.png)

---



Remerciements

**Encadré par** : P. EZZATI

**Développé par** :

- MOHAMED LARBI BENJELLOUN
- MOHAMMED ABIDOU

Contributions bienvenues ! Si vous souhaitez améliorer ce projet, n'hésitez pas à ouvrir une issue ou à soumettre une pull request.
