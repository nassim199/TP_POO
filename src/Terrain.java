import java.util.Date;

public class Terrain extends Bien{
    private int nbrFacade;
    private String statutJuridique;

    public Terrain(String addresse, Wilaya wilaya, Transaction typeTransaction, Proprietaire proprietaire, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrFacade, String statutJuridique) {
        super(addresse, wilaya, typeTransaction, proprietaire, date, superficie, prix, negociable, description, imgsUrl);
        this.nbrFacade = nbrFacade;
        this.statutJuridique = statutJuridique;
    }

    public int getNbrFacade() {
        return nbrFacade;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    @Override
    protected double prixVente() {
        return super.prixVente() + ( (this.nbrFacade > 1) ? 0.5 * this.getPrix() : 0 );
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
