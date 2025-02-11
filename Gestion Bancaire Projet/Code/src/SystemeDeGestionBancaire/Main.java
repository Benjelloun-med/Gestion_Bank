package SystemeDeGestionBancaire;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Compte> comptes = new ArrayList<>();
        BaseDeDonnees baseDeDonnees = new BaseDeDonnees();
        comptes = baseDeDonnees.chargerComptes();
        int prochainId = (comptes.size() == 0) ? 1000000 : comptes.size() + 1000001;
        new Connexion(comptes, baseDeDonnees, prochainId);
    }

    public static JFrame creerFenetre(int largeur, int hauteur) {
        JFrame frame = new JFrame("Système de Gestion Bancaire");
        frame.setSize(largeur, hauteur);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    public static JLabel creerLabel(String texte, int taille) {
        JLabel label = new JLabel(texte, SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, taille));
        return label;
    }

    public static JTextField creerChampTexte(int taille) {
        JTextField champ = new JTextField();
        champ.setFont(new Font("Tahoma", Font.PLAIN, taille));
        return champ;
    }

    public static JButton creerBouton(String texte, int taille) {
        JButton bouton = new JButton(texte);
        bouton.setFont(new Font("Tahoma", Font.BOLD, taille));
        return bouton;
    }
}
