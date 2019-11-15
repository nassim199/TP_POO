import java.util.Date;

public class Maison extends Habitable{
    private int nbrEtages;
    private boolean contientJardin, contientGarage, contientPiscine;
    private double superficieHabitable;

    public Maison(String addresse, String wilaya, Transaction typeTransaction, Coordonnees coordonnees, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrPieces, boolean estMeuble, int nbrEtages, boolean contientJardin, boolean contientGarage, boolean contientPiscine, double superficieHabitable) {
        super(addresse, wilaya, typeTransaction, coordonnees, date, superficie, prix, negociable, description, imgsUrl, nbrPieces, estMeuble);
        this.nbrEtages = nbrEtages;
        this.contientJardin = contientJardin;
        this.contientGarage = contientGarage;
        this.contientPiscine = contientPiscine;
        this.superficieHabitable = superficieHabitable;
    }

    public int getNbrEtages() {
        return nbrEtages;
    }

    public boolean isContientJardin() {
        return contientJardin;
    }

    public boolean isContientGarage() {
        return contientGarage;
    }

    public boolean isContientPiscine() {
        return contientPiscine;
    }

    public double getSuperficieHabitable() {
        return superficieHabitable;
    }

    public String avoirType() {
        return "Maison";
    }

    public void afficher() {
        super.afficher();
        //TODO override the function afficher
    }
    public void afficherDetails() {
        super.afficherDetails();
        //TODO override the function afficher
    }
}
