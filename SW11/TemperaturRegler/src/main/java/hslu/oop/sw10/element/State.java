package hslu.oop.sw10.element;

public enum State {
    FLUID("fluessig"), SOLID("fest"), GAS("gasfoermig");

    private final String value;

    private State(final String value){
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
