package hslu.oop.sw08;

public abstract class ChemicalElement{

    private final ChemicalFormula chemicalFormula;
    private final float schmelzPunkt;
    private final float siedeTemp;

    public ChemicalElement(final ChemicalFormula chemicalFormula, final float schmelzPunkt, final float siedeTemp) {
        this.chemicalFormula = chemicalFormula;
        this.schmelzPunkt = schmelzPunkt;
        this.siedeTemp = siedeTemp;
    }

    public State getState(float temperature){
        if (temperature <  schmelzPunkt){
            return State.fest;
        }else if (temperature < siedeTemp){
            return State.fluessig;
        }else {
            return State.gasfoermig;
        }
    }

    public ChemicalFormula getChemicalFormula() {
        return this.chemicalFormula;
    }
}

