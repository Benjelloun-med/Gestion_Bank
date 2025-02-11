package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Retrait {

    public Retrait(Compte compte, BaseDeDonnees baseDeDonnees, ArrayList<Compte> comptes) {
        JFrame frame = Main.creerFenetre(400, 250);
        JLabel titre = Main.creerLabel("Retirer des fonds", 23);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelMontant = Main.creerLabel("Montant à retirer", 18);
        JTextField champMontant = Main.creerChampTexte(20);

        panel.add(labelMontant);
        panel.add(champMontant);

        JButton boutonRetrait = Main.creerBouton("Retirer", 20);

        boutonRetrait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double montant = Double.parseDouble(champMontant.getText());
                    if (montant <= 0) {
                        JOptionPane.showMessageDialog(frame, "Le montant doit être supérieur à 0 !");
                        return;
                    }

                    if (montant > compte.getSolde()) {
                        JOptionPane.showMessageDialog(frame, "Fonds insuffisants !");
                        return;
                    }

                    // Mise à jour du solde
                    compte.retirer(montant);
                    baseDeDonnees.sauvegarderComptes(comptes);

                    JOptionPane.showMessageDialog(frame, "Retrait effectué avec succès !\nNouveau solde : " + compte.getSolde());
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un montant valide !");
                }
            }
        });

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(boutonRetrait, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
