package hslu.oop.sw04;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ACTest {
    String acName = "🆒😎";
    AC ac = new AC(acName);

    @Test
    void test_switchOn() {
        ac.switchOn();

        Assertions.assertTrue(ac.isSwitchedOn());
    }

    @Test
    void test_switchOff() {
        ac.switchOff();

        Assertions.assertTrue(ac.isSwitchedOff());
    }

    @Test
    void test_getName(){
        Assertions.assertEquals(this.acName, ac.getName());
    }
}