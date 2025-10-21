package hslu.oop.sw06;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalcMaxTest {

    CalcMax calcMax = new CalcMax();

    @Test
    void test_two_param_max_firstparam(){
        int result = calcMax.max(2,1);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_two_param_max_secondparam(){
        int result = calcMax.max(1,2);

        Assertions.assertEquals(2, result);
    }

    @Test
    void test_two_param_max_bothEquals(){
        int result = calcMax.max(2,2);

        Assertions.assertEquals(2, result);
    }
}