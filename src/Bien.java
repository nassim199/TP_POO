import java.util.Date;

abstract public class Bien implements Comparable<Bien>{
    private String addresse, wilaya;
    private Transaction typeTransaction;
    private Coordonnees coordonnees;
    private Date date;
    private double superficie, prix;
    private boolean negociable;
    private String description;
    private String[] imgsUrl;

    public Bien(String addresse, String wilaya, Transaction typeTransaction, Coordonnees coordonnees, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl) {
        this.addresse = addresse;
        this.wilaya = wilaya;
        this.typeTransaction = typeTransaction;
        this.coordonnees = coordonnees;
        this.date = date;
        this.superficie = superficie;
        this.prix = prix;
        this.negociable = negociable;
        this.description = description;
        this.imgsUrl = imgsUrl;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getWilaya() {
        return wilaya;
    }

    public Transaction getTypeTransaction() {
        return typeTransaction;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Date getDate() {
        return date;
    }

    public double getSuperficie() {
        return superficie;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isNegociable() {
        return negociable;
    }

    public String getDescription() {
        return description;
    }

    public String[] getImgsUrl() {
        return imgsUrl;
    }

    public double prixMetreCarre() {
        return prix / superficie;
    }

    abstract public String avoirType();

    public void afficher() {
        //TODO add afficher
    }

    public void afficherDetails() {
        //TODO add afficher details
    }

    @Override
    public int compareTo(Bien bien) {
        //TODO complete the function compare to
        return 0;
    }
}
