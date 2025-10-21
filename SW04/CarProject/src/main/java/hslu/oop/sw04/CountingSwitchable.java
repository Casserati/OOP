package hslu.oop.sw04;

public abstract class CountingSwitchable implements Switchable, Named{

    private int switchCounter;
    private String name;
    private State state;

    @Override
    public void switchOn() {
        this.state = State.ON;
        this.switchCounter++;
    }

    @Override
    public void switchOff() {
        this.state = State.OFF;
    }

    @Override
    public boolean isSwitchedOn() {
            return state == State.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return state == State.OFF;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String finalName) {
        this.name = name;
    }

    public long getSwitchCount(){
        return this.switchCounter;
    }
}
