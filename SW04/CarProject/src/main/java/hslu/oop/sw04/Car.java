package hslu.oop.sw04;

public class Car implements Switchable {

    private State state;
    private Switchable ac = new AC();
    private Switchable engine = new Engine();

    @Override
    public void switchOn() {
        this.state = State.ON;
        this.engine.switchOn();
        this.ac.switchOn();
        System.out.println("Car switch on");
    }

    @Override
    public void switchOff() {
        this.state = State.OFF;
        this.engine.switchOff();
        this.ac.switchOff();
        System.out.println("Car switch off");
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
