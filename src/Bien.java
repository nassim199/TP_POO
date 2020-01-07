import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

abstract public class Bien implements Comparable<Bien>{
    private String addresse;
    private Wilaya wilaya;
    private Transaction typeTransaction;
    private Proprietaire proprietaire;
    private Date date;
    private double superficie, prix;
    private boolean negociable;
    private String description;
    private String[] imgsUrl;

    public Bien(String addresse, Wilaya wilaya, Transaction typeTransaction, Proprietaire proprietaire, Date date, double superficie, double prix, boolean negociable, String description, String[] imgsUrl) {
        this.addresse = addresse;
        this.wilaya = wilaya;
        this.typeTransaction = typeTransaction;
        this.proprietaire = proprietaire;
        this.date = date;
        this.superficie = superficie;
        this.prix = prix;
        this.negociable = negociable;
        this.description = description;
        this.imgsUrl = imgsUrl;

        proprietaire.ajouterBien(this);
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public String getAddresse() {
        return addresse;
    }

    public Transaction getTypeTransaction() {
        return typeTransaction;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
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

    public double calculerPrix() {
        double resultat = 0;
        switch (this.getTypeTransaction()) {
            case Vente:
            case Echange:
                resultat = this.prixVente();
                break;
            case Location:
                resultat = this.prixLocation();
                break;
        }
        return resultat;
    }

    public double calculerPrix(Wilaya wilaya) {
        double resultat = 0;
        switch (this.getTypeTransaction()) {
            case Vente:
                resultat = this.prixVente();
            case Echange:
                resultat = this.prixVente();
                if (wilaya != null && !this.wilaya.getNomWilaya().equals(wilaya.getNomWilaya()))
                    resultat += resultat * 0.0025;
                break;
            case Location:
                resultat = this.prixLocation();
                break;
        }
        return resultat;
    }

    protected double prixVente() {
        double resultat = prix;
        if (this.prix < 5000000) {
            if (this.wilaya.getPrixMetreCarre() < 50000) {
                resultat += prix * 0.03;
            } else {
                resultat += prix * 0.035;
            }
        } else if (this.prix >= 5000000 && this.prix < 15000000) {
            if (this.wilaya.getPrixMetreCarre() < 50000) {
                resultat += prix * 0.02;
            } else {
                resultat += prix * 0.025;
            }
        } else if (this.prix >= 15000000) {
            if (this.wilaya.getPrixMetreCarre() < 70000) {
                resultat += prix * 0.01;
            } else {
                resultat += prix * 0.02;
            }
        }
        return resultat;
    }
    protected double prixLocation() {
        double resultat = prix;

        if (this.superficie < 60) {
            if (this.wilaya.getPrixMetreCarre() < 50000) {
                resultat += prix * 0.01;
            } else {
                resultat += prix * 0.015;
            }
        } else if (this.superficie >= 60 && this.superficie < 150) {
            if (this.wilaya.getPrixMetreCarre() < 50000) {
                resultat += prix * 0.02;
            } else {
                resultat += prix * 0.025;
            }
        } else if (this.superficie >= 150) {
            if (this.wilaya.getPrixMetreCarre() < 50000) {
                resultat += prix * 0.03;
            } else {
                resultat += prix * 0.035;
            }
        }

        return resultat;
    }

    public void afficher() {
        //TODO add afficher
    }

    public void afficherDetails() {
        //TODO add afficher details
    }
    public void afficherDetails(Wilaya wilaya) {
        //TODO add afficher details
    }

    public void afficherPrixFinal() {
        System.out.println("Prix final du bien : " + this.calculerPrix());
    }

    public void afficherPrixFinal(Wilaya wilaya) {
        System.out.println("Prix final du bien : " + this.calculerPrix(wilaya));
    }

    @Override
    public int compareTo(Bien bien) {
        int i = this.addresse.compareTo(bien.getAddresse());
        if (i != 0)
            i = this.date.compareTo(bien.getDate());
        return i;
    }

}
