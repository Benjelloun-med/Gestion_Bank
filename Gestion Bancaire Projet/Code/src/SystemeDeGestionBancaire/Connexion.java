package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Connexion {

    public Connexion(ArrayList<Compte> comptes, BaseDeDonnees baseDeDonnees, int prochainId) {
        JFrame frame = Main.creerFenetre(400, 300);
        JLabel titre = Main.creerLabel("Connexion au Système Bancaire", 23);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelId = Main.creerLabel("ID du Compte", 18);
        JLabel labelMotDePasse = Main.creerLabel("Mot de Passe", 18);

        JTextField champId = Main.creerChampTexte(20);
        JPasswordField champMotDePasse = new JPasswordField(20);

        panel.add(labelId);
        panel.add(champId);
        panel.add(labelMotDePasse);
        panel.add(champMotDePasse);

        JPanel panelBoutons = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton boutonConnexion = Main.creerBouton("Connexion", 18);
        JButton boutonCreerCompte = Main.creerBouton("Créer un Compte", 18);

        boutonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(champId.getText());
                    int motDePasse = Integer.parseInt(new String(champMotDePasse.getPassword()));

                    Compte compteTrouve = null;
                    for (Compte compte : comptes) {
                        if (compte.getIdCompte() == id && compte.getMotDePasse() == motDePasse) {
                            compteTrouve = compte;
                            break;
                        }
                    }

                    if (compteTrouve != null) {
                        JOptionPane.showMessageDialog(frame, "Connexion réussie !");
                        new Menu(compteTrouve, baseDeDonnees, comptes);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Identifiant ou mot de passe incorrect !");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer des valeurs valides !");
                }
            }
        });

        boutonCreerCompte.addActionListener(e -> {
            new CreerCompte(prochainId, comptes, baseDeDonnees);
            frame.dispose();
        });

        panelBoutons.add(boutonConnexion);
        panelBoutons.add(boutonCreerCompte);

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBoutons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
