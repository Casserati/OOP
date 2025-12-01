package hslu.oop.sw11.element;

public enum ChemicalFormula {
    Pb("Blei"), N("Stickstoff"), Hg("Quecksilver");


    private final String value;

    private ChemicalFormula(final String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
