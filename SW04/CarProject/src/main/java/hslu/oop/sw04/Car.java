package hslu.oop.sw04;

import java.util.ArrayList;
import java.util.List;

public class Car extends CountingSwitchable {

    private final List<CountingSwitchable> switchableList = new ArrayList<>();

    public Car() {
        switchableList.add(new AC("AC"));
        switchableList.add(new Engine("RB26"));
    }

    @Override
    public void switchOn() {
        super.switchOn();
        System.out.println("Switching on Car");
        //switchableList.forEach(CountingSwitchable::switchOn); //Method reference
        switchableList.forEach(switchable -> switchable.switchOn()); //Lamda
    }

    @Override
    public void switchOff() {
        super.switchOff();
        System.out.println("Switching off Car");
        switchableList.forEach(CountingSwitchable::switchOff);
    }

    @Override
    public long getSwitchCount() {
        return super.getSwitchCount() + switchableList.stream().mapToLong(CountingSwitchable::getSwitchCount).sum();
    }

    public void switchOnComponent(Class<? extends CountingSwitchable> component){
        switchableList.forEach(countingSwitchable ->{
            if (countingSwitchable.getClass().equals(component)){
                countingSwitchable.switchOn();
            }
        });    }

    public void switchOffComponent(Class<? extends CountingSwitchable> component){
        switchableList.forEach(countingSwitchable ->{
            if (countingSwitchable.getClass().equals(component)){
                countingSwitchable.switchOff();
            }
        });
    }
}
