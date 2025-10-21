package hslu.oop.sw04;

public abstract class CountingSwitchable implements Switchable, Named{

    private int switchCounter;
    private String name;
    private State state;

    @Override
    public void switchOn() {
        this.state = State.ON;
        System.out.println("Switching on");
        this.switchCounter++;
    }

    @Override
    public void switchOff() {
        this.state = State.OFF;
        System.out.println("Switching off");
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
