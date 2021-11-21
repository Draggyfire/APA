import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Compteur {
    private String nomFichier;
    private int nbMots;
    private int nbMots5;


    public abstract void addOccurrence(String mot);


    public Compteur (String fichierTexte){
        try {
            Scanner in = new Scanner(new File(fichierTexte));
            in.useDelimiter("\\s|,|;|!|\\(|\\)|\"|\\.|-|'");
            while(in.hasNext()){
                String mot = in.next();
                mot = mot.toLowerCase();
                if (mot.length()>4){
                    this.addOccurrence(mot);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
