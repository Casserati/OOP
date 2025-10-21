package hslu.oop.sw06;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcMaxTest {

    CalcMax calcMax = new CalcMax();

    @Test
    void test_twoParamMax_firstParam() {
        int result = calcMax.max(2, 1);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_twoParamMax_secondParam() {
        int result = calcMax.max(1, 2);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_twoParamMax_bothEquals() {
        int result = calcMax.max(2, 2);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_threeParamMax_firstParam() {
        int result = calcMax.max(2, 1, 0);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_threeParamMax_secondParam() {
        int result = calcMax.max(1, 2, 0);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_threeParamMax_thirdParam() {
        int result = calcMax.max(0, 1, 2);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_threeParamMax_firstTwoEqual() {
        int result = calcMax.max(1, 1, 0);

        Assertions.assertEquals(1, result);
    }

    @Test
    void test_threeParamMax_lastTwoEqual() {
        int result = calcMax.max(0, 1, 1);

        Assertions.assertEquals(1, result);
    }

    @Test
    void test_threeParamMax_firstAndLastTwoEqual() {
        int result = calcMax.max(1, 0, 1);

        Assertions.assertEquals(1, result);
    }
    @Test
    void test_threeParamMax_AllEqual() {
        int result = calcMax.max(2, 2, 2);

        Assertions.assertEquals(2, result);
    }
}