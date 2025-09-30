package hslu.oop.sw02;

public class Temperatur {

    ChemicalElement blei = new ChemicalElement(ChemicalFormular.Pb, 100.0f, 50.0f, 10.0f);
    ChemicalElement stickStoff = new ChemicalElement(ChemicalFormular.N, 50.0f, 20.0f, -10.0f);
    ChemicalElement queckSilver = new ChemicalElement(ChemicalFormular.Hg, 25.0f, 0.0f, -70.0f);


    float temperatureInCelsius;

    /**
     * Default Constructor
     * sets default temperature to 20 degree Celsius
     */
    public Temperatur() {
        this.temperatureInCelsius = 20.0f;
    }

    /**
     * Constructor
     * sets default temperature to given float value degree Celsius
     */
    public Temperatur(float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)){
            this.temperatureInCelsius = temperatureInCelsius;
        }
    }

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)) {
            this.temperatureInCelsius = temperatureInCelsius;
        }
    }

    /**
     * @return current temperature of class in Kelvin
     */
    public float getTemperatureInKelvin() {
        return fromCelsiusToKelvin(temperatureInCelsius);
    }

    /**
     * @return current temperature of class in Fahrenheit
     */
    public float getTemperatureInFahrenheit() {
        return fromCelsiusToFahrenheit(temperatureInCelsius);
    }

    /**
     * changes temperature relative to given value
     *
     * @param temperature relative temperature
     */
    public void changeTemperature(float temperature) {
        if (verifyTemperatureValid(this.temperatureInCelsius + temperature)) {
            this.temperatureInCelsius =+ temperature;
        }
    }

    private boolean verifyTemperatureValid(float value) {
        if (fromCelsiusToKelvin(value) > 1000f || fromCelsiusToKelvin(value) < 0f) {
            System.out.println("Temperatur ist nicht gültig für den gegebenen Wertebereich!");
            return false;
        } else {
            return true;
        }
    }

    private float fromCelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    private float fromCelsiusToKelvin(float temperatureInCelsius){
        return temperatureInCelsius + 273.15f;
    }

    private State returnStateBasedOnTemp(ChemicalElement chemicalElement){
        return chemicalElement.getState(temperatureInCelsius);
    }

    private String returnStateBasedOnTempSwitch(String chemicalElement){
        return switch (chemicalElement) {
            case "Hg" -> returnStateBasedOnTemp(queckSilver).toString();
            case "N" -> returnStateBasedOnTemp(stickStoff).toString();
            case "Pb" -> returnStateBasedOnTemp(blei).toString();
            default -> {
                System.out.println("Sie haben kein gültiges Element verwendet");
                yield "Error";
            }
        };
    }
}
