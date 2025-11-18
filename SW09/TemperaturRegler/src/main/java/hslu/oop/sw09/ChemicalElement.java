package hslu.oop.sw09;

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
            return State.SOLID;
        }else if (temperature < siedeTemp){
            return State.FLUID;
        }else {
            return State.GAS;
        }
    }

    public ChemicalFormula getChemicalFormula() {
        return this.chemicalFormula;
    }
}

