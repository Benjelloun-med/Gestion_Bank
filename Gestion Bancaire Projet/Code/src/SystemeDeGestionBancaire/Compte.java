package SystemeDeGestionBancaire;

public class Compte {

    private String prenom;
    private String nom;
    private int idCompte;
    private double solde;
    private int motDePasse;

    public Compte() {}

    public Compte(String prenom, String nom, int idCompte, double solde, int motDePasse) {
        this.prenom = prenom;
        this.nom = nom;
        this.idCompte = idCompte;
        this.solde = solde;
        this.motDePasse = motDePasse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(int motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void retirer(double montant) {
        this.solde -= montant;
    }

    public void deposer(double montant) {
        this.solde += montant;
    }
}
