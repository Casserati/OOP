package hslu.oop.sw08;

public class Mercury extends  ChemicalElement {

    public Mercury() {
        super(ChemicalFormula.Hg, -70.0f, 0.0f);
    }

    @Override
    public String toString() {
        return super.toString() + "POISONOUS!";
    }
}
