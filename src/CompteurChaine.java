public class CompteurChaine extends Compteur {
    private MotChaine elements;

    public void addOccurrence(String mot) {
        if (elements == null) {
            elements = new MotChaine(mot);
        } else {
            MotChaine next = elements;
            while (next.getNext() != null) {
                if (next.getMot().equals(mot)) {
                    next.nouvelleOccurrence();
                    return;
                }
                next = next.getNext();
            }
            next.setNext(new MotChaine(mot));
        }
    }

    public CompteurChaine(String fichierTexte) {
        super(fichierTexte);
    }

    public MotChaine motFrequent() {
        MotChaine next = elements;
        MotChaine avantGrand = null;
        MotChaine plusGrand = elements;
        MotChaine newList = null;

        for (int i = 0; i < 10; i++) {

            while (next.getNext() != null) {
                if (plusGrand.getOccurence() < next.getNext().getOccurence()) {
                    plusGrand = next.getNext();
                    avantGrand = next;
                }
                next = next.getNext();
            }
            MotChaine tmp = newList;
            if(tmp !=null) {
                while (tmp.getNext() != null) {
                    tmp = tmp.getNext();
                }
                tmp.setNext(plusGrand);
            }else
                newList=plusGrand;

            if (plusGrand.getNext() != null && avantGrand != null)
                avantGrand.setNext(plusGrand.getNext());
            else if (avantGrand != null)
                avantGrand.setNext(null);
            else
                elements = elements.getNext();

            plusGrand.setNext(null);
            plusGrand = elements;
            next = elements;
            avantGrand = null;
        }
        return newList;
    }

    @Override
    public void statistique() {
        super.statistique();
        System.out.println("Mot les plus fréquents :");
        MotChaine mot = motFrequent();
        for (int i = 0; i < 10; i++) {
            System.out.println(mot.getOccurence() + " " + mot.getMot());
            mot = mot.getNext();
        }
    }

    public static void main(String[] args) {
        Compteur c;
        if (args.length < 1)
            System.err.println("nom de fichier manquant");
        else {
            c = new CompteurChaine(args[0]);
            c.statistique();
        }
    }
}
