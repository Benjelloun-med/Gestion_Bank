package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Depot {

    public Depot(Compte compte, BaseDeDonnees baseDeDonnees, ArrayList<Compte> comptes) {
        JFrame frame = Main.creerFenetre(400, 250);
        JLabel titre = Main.creerLabel("Dépôt sur le compte", 23);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelMontant = Main.creerLabel("Montant à déposer", 18);
        JTextField champMontant = Main.creerChampTexte(20);

        panel.add(labelMontant);
        panel.add(champMontant);

        JButton boutonDepot = Main.creerBouton("Déposer", 20);

        boutonDepot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double montant = Double.parseDouble(champMontant.getText());
                    if (montant <= 0) {
                        JOptionPane.showMessageDialog(frame, "Le montant doit être supérieur à 0 !");
                        return;
                    }

                    // Mise à jour du solde
                    compte.deposer(montant);
                    baseDeDonnees.sauvegarderComptes(comptes);

                    JOptionPane.showMessageDialog(frame, "Dépôt effectué avec succès !\nNouveau solde : " + compte.getSolde());
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer un montant valide !");
                }
            }
        });

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(boutonDepot, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
