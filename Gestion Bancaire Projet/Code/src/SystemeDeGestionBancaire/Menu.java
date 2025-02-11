package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Menu {

    public Menu(Compte compte, BaseDeDonnees baseDeDonnees, ArrayList<Compte> comptes) {
        JFrame frame = Main.creerFenetre(400, 400);
        JLabel titre = Main.creerLabel("Bienvenue " + compte.getPrenom() + " " + compte.getNom(), 23);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton boutonDepot = Main.creerBouton("Déposer", 22);
        JButton boutonRetrait = Main.creerBouton("Retirer", 22);
        JButton boutonSolde = Main.creerBouton("Voir le solde", 22);
        JButton boutonVirement = Main.creerBouton("Effectuer un virement", 22);
        JButton boutonDeconnexion = Main.creerBouton("Se déconnecter", 22);

        boutonDepot.addActionListener(e -> new Depot(compte, baseDeDonnees, comptes));
        boutonRetrait.addActionListener(e -> new Retrait(compte, baseDeDonnees, comptes));
        boutonSolde.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Votre solde : " + compte.getSolde()));
        boutonVirement.addActionListener(e -> new Virement(compte, comptes, baseDeDonnees));
        boutonDeconnexion.addActionListener(e -> {
            new Connexion(comptes, baseDeDonnees, compte.getIdCompte() + 1);
            frame.dispose(); // Fermer le menu actuel
        });

        panel.add(boutonDepot);
        panel.add(boutonRetrait);
        panel.add(boutonSolde);
        panel.add(boutonVirement);
        panel.add(boutonDeconnexion);

        frame.add(titre, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
