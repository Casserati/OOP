package hslu.oop.sw04;

public class AC implements Switchable {

    private State state;

    @Override
    public void switchOn() {
        this.state = State.ON;
        System.out.println("AC switched on");
    }

    @Override
    public void switchOff() {
        this.state = State.OFF;
        System.out.println("AC switched off");
    }

    @Override
    public boolean isSwitchedOn() {
        return this.state == State.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.state == State.OFF;
    }
}
