import java.util.Date;

abstract public class Habitable extends Bien{
    private int nbrPieces;
    private boolean estMeuble;

    public Habitable(String addresse, Wilaya wilaya, Transaction typeTransaction, Proprietaire proprietaire, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrPieces, boolean estMeuble) {
        super(addresse, wilaya, typeTransaction, proprietaire, date, superficie, prix, negociable, description, imgsUrl);
        this.nbrPieces = nbrPieces;
        this.estMeuble = estMeuble;
    }

    public int getNbrPieces() {
        return nbrPieces;
    }

    public boolean isEstMeuble() {
        return estMeuble;
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
