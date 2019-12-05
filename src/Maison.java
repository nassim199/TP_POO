import java.util.Date;

public class Maison extends Habitable{
    private int nbrEtages;
    private boolean contientJardin, contientGarage, contientPiscine;
    private double superficieHabitable;

    public Maison(String addresse, Wilaya wilaya, Transaction typeTransaction, Proprietaire proprietaire, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrPieces, boolean estMeuble, int nbrEtages, boolean contientJardin, boolean contientGarage, boolean contientPiscine, double superficieHabitable) {
        super(addresse, wilaya, typeTransaction, proprietaire, date, superficie, prix, negociable, description, imgsUrl, nbrPieces, estMeuble);
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


    @Override
    protected double prixVente() {
        return super.prixVente() + ( (this.contientGarage || this.contientJardin || this.contientPiscine) ? this.getPrix() * 0.005 : 0 );
    }

    @Override
    protected double prixLocation() {
        return super.prixLocation() + ( (this.contientPiscine) ? 50000 : 0 );
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
