package hslu.oop.sw02;

public record ChemicalElement(ChemicalFormular chemicalFormula, float schmelzPunkt, float siedeTemp){

    public State getState(float temperature){
        if (temperature <  schmelzPunkt){
            return State.fest;
        }else if (temperature < siedeTemp){
            return State.fluessig;
        }else {
            return State.gasfoermig;
        }
    }
}

