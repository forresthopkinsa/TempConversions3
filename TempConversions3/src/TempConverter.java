
/**
 * TempConverter converts a temperature from Fahrenheit to Celcius and Kelvin
 * 
 * @author Forrest Hopkins 
 * @version 1.7
 */
public class TempConverter
{
    //tempC holds Celcius temp
    private double tempC;
    //tempF holds Fahrenheit temp
    private double tempF;
    //tempK holds Kelvin temp
    private double tempK;

    /**
     * getTempC retrieves the Celcius temp
     * 
     * @return a double value containing the Celsius temperature
     */
    public double getTempC() {
        return tempC;
    }

    /**
     * getTempK retrieves the Kelvin temp
     * 
     * @return a double value containing the Kelvin temperature
     */
    public double getTempK() {
        return tempK;
    }

    /**
     * getTempF retrieves the Fahrenheit temp
     * 
     * @return a double value containing the Fahrenheit temperature
     */
    public double getTempF() {
        return tempF;
    }

    /**
     * setTempF sets the Fahrenheit temp
     * 
     * @param tempIn The Fahrenheit value to store
     */
    public boolean setTempF(double tempIn) {
        //check if tempIn is a valid temperature
        if (tempIn < -459.67)
            return false;
        //set Fahrenheit value
        tempF = tempIn;
        //calculate Celsius value
        tempC = (tempF - 32.0) * 5.0 / 9.0;
        //calculate Kelvin value
        tempK = tempC + 273.15;
        return true;
    }

    /**
     * setTempC sets the Celsius temp
     * 
     * @param tempIn The Celsius value to store
     */
    public boolean setTempC(double tempIn) {
        //check if tempIn is a valid temperature
        if (tempIn < -273.15)
            return false;
        //set Celsius value
        tempC = tempIn;
        //calculate Fahrenheit value
        tempF = tempC * 9.0 / 5.0 + 32.0;
        //calculate Kelvin value
        tempK = tempC + 273.15;
        return true;
    }

    /**
     * setTempK sets the Kelvin temp
     * 
     * @param tempIn The Kelvin value to store
     */
    public boolean setTempK(double tempIn) {
        //check if tempIn is a valid temperature
        if (tempIn < 0.0)
            return false;
        //calculate Kelvin value
        tempK = tempIn;
        //calculate Celsius value
        tempC = tempK - 273.15;
        //set Fahrenheit value
        tempF = tempC * 9.0 / 5.0 + 32.0;
        return true;
    }

    /**
     * This constructor sets the Fahrenheit value to the
     * value from tempIn, then calculates
     * equivalent Celsius and Kelvin values using setTempF()
     */
    public TempConverter(double tempIn) {
        setTempF(tempIn);
    }

    /**
     * This constructor just sets the Fahrenheit value
     * to 0, and then calls the alternate constructor.
     */
    public TempConverter() {
        this(0.0);
    }
}