package hslu.oop.sw04;

/**
 * Interface for switching on and off
 */
public interface Switchable {
    /**
     * switches object on
     */
    void switchOn();
    /**
     * switches object off
     */
    void switchOff();

    /**
     * checks if current object is switched on
     * @return true if object is switched on
     */
    boolean isSwitchedOn();

    /**
     * checks if current object is switched off
     * @return true if object is switched off
     */
    boolean isSwitchedOff();
}
