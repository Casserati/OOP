package hslu.oop.sw11.collections;

import hslu.oop.sw11.Temperature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureVerlaufImplTest {

    TemperatureVerlaufImpl temperatureVerlaufImpl;

    @BeforeEach
    void setUp() {
        temperatureVerlaufImpl = new TemperatureVerlaufImpl();
    }

    @Test
    void test_addMethod() {
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(100.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(200.0f));

        Assertions.assertEquals(2, temperatureVerlaufImpl.getCount());
    }

    @Test
    void test_clearMethod() {
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(100.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(200.0f));

        Assertions.assertEquals(2, temperatureVerlaufImpl.getCount());

        temperatureVerlaufImpl.clear();

        Assertions.assertEquals(0, temperatureVerlaufImpl.getCount());
    }

    @Test
    void test_maxValue_emptySet() {
        assertNull(temperatureVerlaufImpl.getMaxValue());
    }


    @Test
    void test_maxValue_nonEmptySet() {
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(100.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(200.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(300.0f));
        assertNotNull(temperatureVerlaufImpl.getMaxValue());
        assertEquals(300.0f, temperatureVerlaufImpl.getMaxValue().getTemperatureInCelsius());
    }

    @Test
    void test_minValue_emptySet() {
        assertNull(temperatureVerlaufImpl.getMinValue());
    }

    @Test
    void test_minValue_nonEmptySet() {
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(-10.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(0.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(10.0f));
        assertNotNull(temperatureVerlaufImpl.getMinValue());
        assertEquals(-10.0f, temperatureVerlaufImpl.getMinValue().getTemperatureInCelsius());
    }

    @Test
    void test_minAverage_emptySet() {
        assertNull(temperatureVerlaufImpl.getAverage());
    }

    @Test
    void test_minAverage_nonEmptySet() {
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(-10.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(0.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(10.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(200.0f));
        temperatureVerlaufImpl.add(Temperature.createFromCelsius(300.0f));
        assertNotNull(temperatureVerlaufImpl.getAverage());
        assertEquals(100.0f, temperatureVerlaufImpl.getAverage().getTemperatureInCelsius());
    }

}