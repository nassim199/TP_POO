import java.util.Date;

public class Terrain extends Bien{
    private int nbrFacade;
    private String statutJuridique;

    public Terrain(String addresse, String wilaya, Transaction typeTransaction, Coordonnees coordonnees, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrFacade, String statutJuridique) {
        super(addresse, wilaya, typeTransaction, coordonnees, date, superficie, prix, negociable, description, imgsUrl);
        this.nbrFacade = nbrFacade;
        this.statutJuridique = statutJuridique;
    }

    public int getNbrFacade() {
        return nbrFacade;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    public String avoirType() {
        return "Terrain";
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
