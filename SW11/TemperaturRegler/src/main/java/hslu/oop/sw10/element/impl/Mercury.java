package hslu.oop.sw10.element.impl;

import hslu.oop.sw10.element.ChemicalElement;
import hslu.oop.sw10.element.ChemicalFormula;

public class Mercury extends ChemicalElement {

    public Mercury() {
        super(ChemicalFormula.Hg, -70.0f, 0.0f);
    }

    @Override
    public String toString() {
        return super.toString() + "POISONOUS!";
    }
}
