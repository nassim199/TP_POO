import java.util.Date;

public class Appartement extends Habitable{
    private int etage, f;
    private boolean estDuplex;

    public Appartement(String addresse, String wilaya, Transaction typeTransaction, Coordonnees coordonnees, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrPieces, boolean estMeuble, int etage, int f, boolean estDuplex) {
        super(addresse, wilaya, typeTransaction, coordonnees, date, superficie, prix, negociable, description, imgsUrl, nbrPieces, estMeuble);
        this.etage = etage;
        this.f = f;
        this.estDuplex = estDuplex;
    }


    public int getEtage() {
        return etage;
    }

    public int getF() {
        return f;
    }

    public boolean isEstDuplex() {
        return estDuplex;
    }
    @Override
    public String avoirType() {
        return "Appartement";
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
