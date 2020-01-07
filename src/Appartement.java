import java.util.Date;

public class Appartement extends Habitable{
    private int etage;
    private boolean estDuplex, contientAscenseur;

    public Appartement(String addresse, Wilaya wilaya, Transaction typeTransaction, Proprietaire proprietaire, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl, int nbrPieces, boolean estMeuble, int etage, boolean estDuplex, boolean contientAscenseur) throws DuplexException{
        super(addresse, wilaya, typeTransaction, proprietaire, date, superficie, prix, negociable, description, imgsUrl, nbrPieces, estMeuble);
        this.etage = etage;
        if (nbrPieces == 1 && estDuplex)
            throw new DuplexException();
        this.estDuplex = estDuplex;
        this.contientAscenseur = contientAscenseur;
    }


    public int getEtage() {
        return etage;
    }

    public boolean isEstDuplex() {
        return estDuplex;
    }

    public boolean isContientAscenseur() {
        return contientAscenseur;
    }

    @Override
    protected double prixVente() {
        return ( super.prixVente() + ( (this.etage >= 0 && this.etage <=2) ? 50000 : 0 ) );
    }

    @Override
    protected double prixLocation() {
        double frais1 = (this.etage >= 0 && this.etage <=2) ? 5000 : 0 ; // frais dans le cas l'appartement est entre 0 et 2eme etage
        double frais2 = ( !this.contientAscenseur && this.etage >=6 ) ? 500 : 0;
        return super.prixLocation() + frais1 - frais2 * this.getWilaya().getPrixMetreCarre();
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
