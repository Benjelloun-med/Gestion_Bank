package SystemeDeGestionBancaire;

import java.io.*;
import java.util.ArrayList;

public class BaseDeDonnees {

    private File fichier;

    public BaseDeDonnees() {
        fichier = new File("Fichiers/Data.txt");
        if (!fichier.exists()) {
            try {
                fichier.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Compte> chargerComptes() {
        ArrayList<Compte> comptes = new ArrayList<>();
        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                String[] data = ligne.split(";");
                if (data.length == 5) {
                    Compte compte = new Compte(
                            data[0],
                            data[1],
                            Integer.parseInt(data[2]),
                            Double.parseDouble(data[3]),
                            Integer.parseInt(data[4])
                    );
                    comptes.add(compte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comptes;
    }

    public void sauvegarderComptes(ArrayList<Compte> comptes) {
        try (PrintWriter ecrivain = new PrintWriter(fichier)) {
            for (Compte compte : comptes) {
                ecrivain.println(compte.getPrenom() + ";" +
                        compte.getNom() + ";" +
                        compte.getIdCompte() + ";" +
                        compte.getSolde() + ";" +
                        compte.getMotDePasse());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
