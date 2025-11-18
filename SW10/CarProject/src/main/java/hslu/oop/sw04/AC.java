package hslu.oop.sw04;

public class AC extends CountingSwitchable {

    public AC(String name) {
        super.setName(name);
    }

    @Override
    public void switchOn() {
        super.switchOn();
        System.out.println("Switching on AC");
    }

    public void switchOff() {
        super.switchOff();
        System.out.println("Switching off AC");
    }
}
