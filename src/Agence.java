import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Agence {
    private List<Bien> biens = new LinkedList<Bien>();
    private TreeSet<Bien> archives = new TreeSet<>();
    private List<Proprietaire> proprietaires = new LinkedList<>();

    private boolean isAuth = false;

    private final String password = "esi";

    public void Login(String passowrd) {
        if (this.password.equals(passowrd)) {
            isAuth = true;
        } else {
            System.err.println("Votre mot de passe est INCORRECTE");
        }
    }
    public void deconnecter() {
        isAuth = false;
    }

    public void ajouterBien(Bien bien) {
        if (!isAuth)
            return;
        Proprietaire proprietaire = bien.getProprietaire();

        if (!this.proprietaires.contains(proprietaire)) {
            this.proprietaires.add(proprietaire);
        }
        this.biens.add(bien);
    }

    public void modifierBien(int i, Bien bien) {
        if (!isAuth)
            return;
        this.biens.set(i, bien);
    }

    public Bien supprimerBien(int i) {
        if (!isAuth)
            return null;
        Bien bien = this.biens.get(i);
        int indice = this.proprietaires.indexOf(bien.getProprietaire());

        if (indice != -1) {
            Proprietaire proprietaire = this.proprietaires.get(indice);
            int indiceBien = proprietaire.getBiens().indexOf(bien);
            if (indiceBien != -1) {
                proprietaire.getBiens().remove(indiceBien);
            }
            if (proprietaire.getBiens().isEmpty()) {
                this.proprietaires.remove(indice);
            }
        }

        return this.biens.remove(i);
    }

    public void afficherBiens() {
        for (Bien bien : biens) {
            bien.afficher();
            System.out.println("***********************************************");
        }
    }

    public void afficherDetails(int i) {
        this.biens.get(i).afficherDetails();
    }
    public void afficherDetails(int i, Wilaya wilaya) {
        this.biens.get(i).afficherDetails(wilaya);
    }

    public void afficherPrixFinaux() {
        int i = 1;
        for (Bien bien : biens) {
            System.out.println("Bien numero " + i + " : ");
            bien.afficherPrixFinal();
        }
    }
    public void afficherPrixFinaux(Wilaya wilaya) {
        int i = 1;
        for (Bien bien : biens) {
            System.out.println("Bien numero " + i + " : ");
            bien.afficherPrixFinal(wilaya);
        }
    }

    public void afficherPrixFinal(int i) {
        this.biens.get(i).afficherPrixFinal();
    }

    public void afficherPrixFinal(int i, Wilaya wilaya) {
        this.biens.get(i).afficherPrixFinal(wilaya);
    }

    public void afficherBiensProprietaire(int i) {
        this.proprietaires.get(i).afficherBiens();
    }
    public void archiver(int i) {
        if (!isAuth)

        this.archives.add(this.biens.remove(i));
    }

    private boolean bienValide(Bien bien, Transaction transaction, Wilaya wilaya, double prixMin, double prixMax, String type, double superficieMin, int nbrPiecesMin ) {
        if (transaction != null) {
            if (bien.getTypeTransaction() != transaction)
                return false;
        }
        if (wilaya != null) {
            if (!bien.getWilaya().getNomWilaya().equals(wilaya.getNomWilaya()))
                return false;
        }
        if (prixMin != 0) {
            if (bien.calculerPrix(wilaya) < prixMin)
                return false;
        }
        if (prixMax != 0) {
            if(bien.calculerPrix(wilaya) > prixMax)
                return false;
        }

        if (!type.equals("")) {
            switch (type) {
                case "Maison":
                    if (!(bien instanceof Maison))
                        return false;
                case "Appartement":
                    if (!(bien instanceof Appartement))
                        return false;
                case "Terrain":
                    if (!(bien instanceof Terrain))
                        return false;
            }
        }

        if (superficieMin != 0) {
            if (bien.getSuperficie() < superficieMin)
                return false;
        }

        if (nbrPiecesMin != 0 ) {
            if (bien instanceof Habitable)
                if (((Habitable) bien).getNbrPieces() < nbrPiecesMin )
                    return false;
            if (bien instanceof Terrain)
                return false;
        }

        return true;
    }

    private void filtrer(Transaction transaction, Wilaya wilaya, double prixMin, double prixMax, String type, double superficieMin, int nbrPiecesMin ) {

        for (Bien bien : biens) {
            if (bienValide(bien, transaction, wilaya, prixMin, prixMax, type, superficieMin, nbrPiecesMin)) {
                bien.afficher();
                System.out.println("***********************************************");
            }
        }

    }



    class Message {
        private Bien bien;
        private String message;

        public Message(int indice, String message) {
            this.bien = biens.get(indice);
            this.message = message;
        }

        public Bien getBien() {
            return bien;
        }

        public String getMessage() {
            return message;
        }
    }

    LinkedList<Message> messages = new LinkedList<Message>();

    public void envoyerMessage(int i, String message) {
        messages.add(new Message(i, message));
    }

    public void afficherMessages() {
        if (!isAuth)
            return;
        for (Message message : messages) {
            System.out.println("Bien :");
            message.getBien().afficher();
            System.out.println("Message :");
            System.out.println(message.getMessage());
            System.out.println();
        }
    }
}
