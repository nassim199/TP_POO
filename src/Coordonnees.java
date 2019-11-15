public class Coordonnees {
    private String nom, prenom, adrMail, tel, addresse;

    public Coordonnees(String nom, String prenom, String adrMail, String tel, String addresse) {
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
}
