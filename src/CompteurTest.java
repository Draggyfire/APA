public class CompteurTest extends Compteur {

    public CompteurTest(String fichierTexte) {
        super(fichierTexte);
    }

    public void addOccurrence(String mot){
        System.out.println(mot);
    }

    @Override
    public void addNbMots() {

    }

    @Override
    public void addNbMots5() {

    }

    @Override
    public int getNbMots() {
        return 0;
    }

    @Override
    public int getNbMots5() {
        return 0;
    }

    public static void main(String[] args){
        Compteur c;
        if (args.length<1)
            System.err.println("nom de fichier manquant");
        else{
            c = new CompteurTest(args[0]);
        }
    }
}