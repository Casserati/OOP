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
        int result = calcMax.max(3, 4);

        Assertions.assertEquals(4, result);
    }

    @Test
    void test_twoParamMax_bothEquals() {
        int result = calcMax.max(5, 5);

        Assertions.assertEquals(5, result);
    }

    @Test
    void test_threeParamMax_firstParam() {
        int result = calcMax.max(10, 9, 8);

        Assertions.assertEquals(10, result);
    }

    @Test
    void test_threeParamMax_secondParam() {
        int result = calcMax.max(12, 13, 11);

        Assertions.assertEquals(13, result);
    }

    @Test
    void test_threeParamMax_thirdParam() {
        int result = calcMax.max(14, 15, 16);

        Assertions.assertEquals(16, result);
    }

    @Test
    void test_threeParamMax_firstTwoEqual() {
        int result = calcMax.max(18, 18, 17);

        Assertions.assertEquals(18, result);
    }

    @Test
    void test_threeParamMax_lastTwoEqual() {
        int result = calcMax.max(19, 20, 20);

        Assertions.assertEquals(20, result);
    }

    @Test
    void test_threeParamMax_firstAndLastTwoEqual() {
        int result = calcMax.max(22, 21, 22);

        Assertions.assertEquals(22, result);
    }
    @Test
    void test_threeParamMax_AllEqual() {
        int result = calcMax.max(23, 23, 23);

        Assertions.assertEquals(23, result);
    }
}