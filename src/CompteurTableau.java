public class CompteurTableau extends Compteur {

    public final int TAILLE_INITIALE = 100;

    private Mot[] elements;

    private int cpt;

    public void addOccurrence(String mot) {
        for (Mot m : elements) {
            if (m.getMot().equals(mot)) {
                m.nouvelleOccurrence();
                return;
            }
        }
        if (cpt < elements.length) {
            elements[cpt] = new Mot(mot);
            cpt++;
        } else {
            Mot[] tmpElements = new Mot[elements.length * 2];
            for (int i = 0; i < cpt; i++) {
                tmpElements[i] = elements[i];
            }
            elements = tmpElements;
            elements[cpt]= new Mot(mot);
            cpt++;
        }
    }

    public CompteurTableau(String fichierTexte) {
        super(fichierTexte);
        cpt = 0;
        elements = new Mot[TAILLE_INITIALE];
    }

}
