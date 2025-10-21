package hslu.oop.sw04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EngineTest {
    String engineName = "N54";
    Engine engine = new Engine(engineName);

    @Test
    void test_switchOn() {
        engine.switchOn();
        Assertions.assertTrue(engine.isSwitchedOn());
    }

    @Test
    void test_switchOff() {
        engine.switchOff();
        Assertions.assertTrue(engine.isSwitchedOff());
    }

    @Test
    void test_getName() {
        Assertions.assertEquals(engineName, engine.getName());
    }

    @Test
    void test_getRpm(){
        engine.switchOn();
        Assertions.assertEquals(500, engine.getRpm());
    }
}