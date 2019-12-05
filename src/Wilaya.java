import java.util.HashMap;

public class Wilaya {
    String nomWilaya;
    double prixMetreCarre;
    private static HashMap<String, Double> prixWilayas;

    public Wilaya(String nomWilaya) throws WilayaInexistante {
        if (prixWilayas.containsKey(nomWilaya)) {
            this.nomWilaya = nomWilaya;
            this.prixMetreCarre = prixWilayas.get(nomWilaya).doubleValue();
        } else {
            throw new WilayaInexistante();
        }
    }

    public Wilaya(String nomWilaya, double prixMetreCarre) {
        this.nomWilaya = nomWilaya;
        this.prixMetreCarre = prixMetreCarre;
        if (!prixWilayas.containsKey(nomWilaya)) {
            prixWilayas.put(nomWilaya, prixMetreCarre);
        }
    }

    public String getNomWilaya() {
        return nomWilaya;
    }

    public double getPrixMetreCarre() {
        return prixMetreCarre;
    }
}
