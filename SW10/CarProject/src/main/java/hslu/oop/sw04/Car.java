package hslu.oop.sw04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Car extends CountingSwitchable implements PropertyChangeListener {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private final List<CountingSwitchable> switchableList = new ArrayList<>();

    public Car() {
        Engine engine = new Engine("RB26");
        engine.addPropertyChangeListener(this);
        switchableList.add(new AC("AC"));
        switchableList.add(engine);

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

    public void switchOnComponent(Class<? extends CountingSwitchable> component) {
        switchableList.forEach(countingSwitchable -> {
            if (countingSwitchable.getClass().equals(component)) {
                countingSwitchable.switchOn();
            }
        });
    }

    public void switchOffComponent(Class<? extends CountingSwitchable> component) {
        switchableList.forEach(countingSwitchable -> {
            if (countingSwitchable.getClass().equals(component)) {
                countingSwitchable.switchOff();
            }
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        LOGGER.info(event.getSource().getClass().getName()
                + " was turned "
                + ((State) event.getNewValue()).name()
                + "!");
    }
}
