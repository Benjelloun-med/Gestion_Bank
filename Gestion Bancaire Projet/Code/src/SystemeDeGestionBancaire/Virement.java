package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Virement {

    public Virement(Compte compteSource, ArrayList<Compte> comptes, BaseDeDonnees baseDeDonnees) {
        JFrame frame = Main.creerFenetre(400, 300);
        JLabel titre = Main.creerLabel("Effectuer un virement", 23);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelDestinataire = Main.creerLabel("ID du compte destinataire", 18);
        JLabel labelMontant = Main.creerLabel("Montant", 18);

        JTextField champDestinataire = Main.creerChampTexte(20);
        JTextField champMontant = Main.creerChampTexte(20);

        panel.add(labelDestinataire);
        panel.add(champDestinataire);
        panel.add(labelMontant);
        panel.add(champMontant);

        JButton boutonVirement = Main.creerBouton("Effectuer le virement", 20);

        boutonVirement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idDestinataire = Integer.parseInt(champDestinataire.getText());
                    double montant = Double.parseDouble(champMontant.getText());

                    if (montant <= 0) {
                        JOptionPane.showMessageDialog(frame, "Le montant doit être positif !");
                        return;
                    }

                    Compte compteDestinataire = null;
                    for (Compte c : comptes) {
                        if (c.getIdCompte() == idDestinataire) {
                            compteDestinataire = c;
                            break;
                        }
                    }

                    if (compteDestinataire == null) {
                        JOptionPane.showMessageDialog(frame, "Compte destinataire introuvable !");
                        return;
                    }

                    if (compteSource.getSolde() < montant) {
                        JOptionPane.showMessageDialog(frame, "Solde insuffisant !");
                        return;
                    }

                    compteSource.retirer(montant);
                    compteDestinataire.deposer(montant);

                    baseDeDonnees.sauvegarderComptes(comptes);
                    JOptionPane.showMessageDialog(frame, "Virement effectué avec succès !");
                    frame.dispose();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Veuillez entrer des valeurs valides !");
                }
            }
        });

        JPanel panelBouton = new JPanel();
        panelBouton.add(boutonVirement);

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panelBouton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
