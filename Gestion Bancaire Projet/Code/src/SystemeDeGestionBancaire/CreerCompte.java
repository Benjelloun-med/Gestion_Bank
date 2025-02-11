package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreerCompte {

    public CreerCompte(int dernierIdCompte, ArrayList<Compte> comptes, BaseDeDonnees baseDeDonnees) {
        JFrame frame = Main.creerFenetre(500, 400);
        JLabel titre = Main.creerLabel("Créer un nouveau compte", 23);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelPrenom = Main.creerLabel("Prénom", 18);
        JLabel labelNom = Main.creerLabel("Nom", 18);
        JLabel labelSolde = Main.creerLabel("Solde Initial", 18);
        JLabel labelMotDePasse = Main.creerLabel("Mot de Passe (4 chiffres)", 18);
        JLabel labelConfirmation = Main.creerLabel("Confirmer le Mot de Passe", 18);

        JTextField champPrenom = Main.creerChampTexte(20);
        JTextField champNom = Main.creerChampTexte(20);
        JTextField champSolde = Main.creerChampTexte(20);
        JPasswordField champMotDePasse = new JPasswordField(20);
        JPasswordField champConfirmation = new JPasswordField(20);

        panel.add(labelPrenom);
        panel.add(champPrenom);
        panel.add(labelNom);
        panel.add(champNom);
        panel.add(labelSolde);
        panel.add(champSolde);
        panel.add(labelMotDePasse);
        panel.add(champMotDePasse);
        panel.add(labelConfirmation);
        panel.add(champConfirmation);

        JButton boutonCreer = Main.creerBouton("Créer le compte", 20);

        boutonCreer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prenom = champPrenom.getText().trim();
                String nom = champNom.getText().trim();
                String soldeTexte = champSolde.getText().trim();
                String motDePasseTexte = new String(champMotDePasse.getPassword());
                String confirmationTexte = new String(champConfirmation.getPassword());

                // Validation des champs
                if (prenom.isEmpty() || nom.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs !");
                    return;
                }

                try {
                    double soldeInitial = Double.parseDouble(soldeTexte);
                    if (soldeInitial < 0) {
                        JOptionPane.showMessageDialog(frame, "Le solde initial doit être positif !");
                        return;
                    }

                    if (motDePasseTexte.length() != 4 || !motDePasseTexte.matches("\\d+")) {
                        JOptionPane.showMessageDialog(frame, "Le mot de passe doit être un nombre de 4 chiffres !");
                        return;
                    }

                    if (!motDePasseTexte.equals(confirmationTexte)) {
                        JOptionPane.showMessageDialog(frame, "Les mots de passe ne correspondent pas !");
                        return;
                    }

                    // Création du compte
                    Compte nouveauCompte = new Compte(prenom, nom, dernierIdCompte, soldeInitial, Integer.parseInt(motDePasseTexte));
                    comptes.add(nouveauCompte);
                    baseDeDonnees.sauvegarderComptes(comptes);

                    JOptionPane.showMessageDialog(frame, "Compte créé avec succès !\nVotre ID de compte est : " + dernierIdCompte);
                    new Connexion(comptes, baseDeDonnees, dernierIdCompte + 1);
                    frame.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un solde valide !");
                }
            }
        });

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(boutonCreer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
