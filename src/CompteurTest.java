public class CompteurTest extends Compteur {

    public CompteurTest(String fichierTexte) {
        super(fichierTexte);
    }

    public void addOccurrence(String mot){
        System.out.println(mot);
    }
    public static void main(String[] args){
        Compteur c;
        if (args.length<1)
            System.err.println("nom de fichier manquant");
        else
            c = new CompteurTest(args[0]);
    }
}