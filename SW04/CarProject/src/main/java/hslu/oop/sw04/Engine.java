package hslu.oop.sw04;

public class Engine implements Switchable{

    private State state;
    private int rpm;

    @Override
    public void switchOn() {
        this.state = State.ON;
        System.out.println("Switching on");
    }

    @Override
    public void switchOff() {
        this.state = State.OFF;
        System.out.println("Switching off");
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
