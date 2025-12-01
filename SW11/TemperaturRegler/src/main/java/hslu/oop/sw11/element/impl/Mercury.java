package hslu.oop.sw11.element.impl;

import hslu.oop.sw11.element.ChemicalElement;
import hslu.oop.sw11.element.ChemicalFormula;

public class Mercury extends ChemicalElement {

    public Mercury() {
        super(ChemicalFormula.Hg, -70.0f, 0.0f);
    }

    @Override
    public String toString() {
        return super.toString() + "POISONOUS!";
    }
}
