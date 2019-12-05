import java.util.LinkedList;

public class Proprietaire {
    private String nom, prenom, adrMail, tel, addresse;
    private LinkedList<Bien> biens = new LinkedList<Bien>();

    public Proprietaire(String nom, String prenom, String adrMail, String tel, String addresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adrMail = adrMail;
        this.tel = tel;
        this.addresse = addresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdrMail() {
        return adrMail;
    }

    public String getTel() {
        return tel;
    }

    public String getAddresse() {
        return addresse;
    }

    public void ajouterBien(Bien bien) {
        biens.add(bien);
    }

    public void supprimerBein(Bien bien) {
        if (biens.contains(bien)) {
            biens.remove(bien);
        }
    }

    public void afficherBiens() {
        for (Bien bien : biens) {
            bien.afficher();
        }
    }
}
