import java.util.Arrays;
import java.util.Collections;

public class CompteurTableau extends Compteur {

    public final int TAILLE_INITIALE = 50;

    private Mot[] elements;

    private int cpt;


    public CompteurTableau(String fichierTexte) {
        super(fichierTexte);
    }

    public void addOccurrence(String mot) {
        if(elements == null){
            cpt = 0;
            elements = new Mot[TAILLE_INITIALE];
            elements[cpt] = new Mot(mot);
            cpt++;
        }else {
            for (Mot m : elements) {
                if (m != null && m.getMot().equals(mot)) {
                    m.nouvelleOccurrence();
                    return;
                }
            }
            if (cpt < elements.length) {
                elements[cpt] = new Mot(mot);
                cpt++;
            } else {
                Mot[] tmpElements = new Mot[elements.length * 2];
                System.arraycopy(elements, 0, tmpElements, 0, cpt);
                elements = tmpElements;
                elements[cpt] = new Mot(mot);
                cpt++;
            }
        }
    }
    public Mot[] motFrequent(){
        int compteur= 0;
        for (Mot element : elements) {
            if (element != null)
                compteur++;
        }

        Mot[] arr = new Mot[compteur];

        System.arraycopy(elements, 0, arr, 0, compteur);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].getOccurence() > arr[j].getOccurence()) {
                    Mot temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Override
    public void statistique() {
        super.statistique();
        System.out.println("Mot les plus fréquents :");
        Mot[] mot = motFrequent();
        for(int i = 0;i<10;i++)
            System.out.println(mot[i].getOccurence() + " " + mot[i].getMot());
    }

    public static void main(String[] args) {
        Compteur c;
        if (args.length < 1)
            System.err.println("nom de fichier manquant");
        else {
            c = new CompteurTableau(args[0]);
            c.statistique();
        }
    }
}
