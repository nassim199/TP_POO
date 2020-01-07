import java.util.*;

public class Main {
    public static void main(String[] args) {
        Agence immoEsi = new Agence();

        Wilaya wilaya1 = new Wilaya("wilaya1", 100000);
        Wilaya wilaya2 = new Wilaya("wilaya2", 30000);
        Wilaya wilaya3 = new Wilaya("wilaya3", 60000);

        Proprietaire proprietaire1 = new Proprietaire("prop1", "prenom", "adr@test.com", "xxxx", "wilaya1");
        Proprietaire proprietaire2 = new Proprietaire("prop2", "prenom", "adr@test.com", "xxxx", "wilaya2");
        Proprietaire proprietaire3 = new Proprietaire("prop3", "prenom", "adr@test.com", "xxxx", "wilaya3");
        Proprietaire proprietaire4 = new Proprietaire("prop4", "prenom", "adr@test.com", "xxxx", "wilaya1");

        try {
            Bien bien = new Appartement("addresse", wilaya2, Transaction.Vente, proprietaire2, new Date(System.currentTimeMillis()), 120, 40000, false, "", null, 4, false, 1, false, false);
//            Bien bien1 = new Maison("addresse", wilaya3, Transaction.Vente, proprietaire1, new Date(System.currentTimeMillis()), 200, 100000, false, "", null, 0);
        } catch (DuplexException duplexException) {
            System.err.println("Le studio ne peut pas etre un duplex");
        } catch (SuperficieException superficieException) {
            System.err.println("La superficie habitable est plus grande que la superficie non-habitable");
        }
    }
}