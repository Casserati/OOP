package hslu.oop.sw02;

public record ChemicalElement(ChemicalFormular chemicalFormula, float gasStateTemp, float liquidTemp, float solidState){

    public State getState(float temperature){
        if (temperature >=  gasStateTemp){
            return State.gasfoermig;
        }else if (temperature < gasStateTemp && temperature >= liquidTemp){
            return State.fluessig;
        }else {
            return State.fest;
        }
    }
}

