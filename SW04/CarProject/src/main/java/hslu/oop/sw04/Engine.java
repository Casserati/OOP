package hslu.oop.sw04;

public class Engine extends CountingSwitchable{

    private int rpm;

    public Engine(String name){
        super.setName(name);
    }

    @Override
    public void switchOn() {
        super.switchOn();
        System.out.println("Switching on Engine");
        this.rpm = 500;
    }

    @Override
    public void switchOff() {
        super.switchOff();
        System.out.println("Switching off Engine");
        this.rpm = 0;
    }

    public int getRpm() {
        return this.rpm;
    }
}
