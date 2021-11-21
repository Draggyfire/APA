import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Compteur {
    private String nomFichier;
    private int nbMots;
    private int nbMots5;


    public abstract void addOccurrence(String mot);

    public void addNbMots() {
        nbMots++;
    }

    public void addNbMots5() {
        nbMots5++;
    }

    public int getNbMots(){
        return nbMots;
    }

    public int getNbMots5(){
        return nbMots5;
    }


    public Compteur(String fichierTexte) {
        nomFichier = fichierTexte;
        nbMots5 = 0;
        nbMots = 0;
        try {
            Scanner in = new Scanner(new File(fichierTexte));
            in.useDelimiter("\\s|,|;|!|\\(|\\)|\"|\\.|-|'");
            while (in.hasNext()) {
                String mot = in.next();
                mot = mot.toLowerCase();
                if (mot.length() > 4) {
                    this.addOccurrence(mot);
                    this.addNbMots5();
                } else
                    this.addNbMots();
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void statistique() {
        System.out.println("Fichier : " + nomFichier);
        System.out.println("Nombre de mots :" + getNbMots());
        System.out.println("Nombre de mots de taille > 4 : "+getNbMots5());
        System.out.println("-----------------");
    }
}
