package hslu.oop.sw10.collections.event;

import hslu.oop.sw10.Temperature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureEventTest {

    @Test
    void test_creation_maxEvent(){
        TemperatureEvent event = new TemperatureEvent("Source", Temperature.createFromCelsius(10), EventType.MaxEvent);

        assertEquals("Source",event.getSource());
        assertEquals(EventType.MaxEvent,event.getType());
    }

    @Test
    void test_creation_minEvent(){
        TemperatureEvent event = new TemperatureEvent("Source", Temperature.createFromCelsius(20), EventType.MinEvent);

        assertEquals("Source",event.getSource());
        assertEquals(EventType.MinEvent,event.getType());
    }
}