import java.util.Scanner;

/**
 * TempConverterMain retrieves the initial Fahrenheit value and prints the results from TempConverter
 * 
 * @author Forrest Hopkins
 * @version 3.7
 */
public class TempConverterMain {
    /**
     * main method read Fahrenheit tempaerature and
     * displays it in Celsius and Kelvin scales.
     */
    public static void main(String[] args) {
        double inputTemp = 0.0;
        String inputUnit = "";
        Scanner keyInput = new Scanner(System.in);
        TempConverter tc1 = new TempConverter();
        boolean anotherTemp = true;
        boolean validTemp = false;
        boolean validUnit = false;

        while (anotherTemp == true) {
            System.out.println("What unit of temperature do you want to convert from?");
            System.out.print("C = Celsius, F = Fahrenheit, K = Kelvin, Q = Quit: ");
            inputUnit = keyInput.nextLine();

            //check type
            validUnit = false;
            while (validUnit == false) {
                if (inputUnit.equalsIgnoreCase("F") ||
                inputUnit.equalsIgnoreCase("C") ||
                inputUnit.equalsIgnoreCase("K") ||
                inputUnit.equalsIgnoreCase("Q")) {
                    validUnit = true;
                }
                else {
                    System.out.println("That wasn't one of the options.");
                    System.out.println("Valid options are: F, C, K, Q");
                    System.out.print("Try again: ");
                    inputUnit = keyInput.nextLine();
                }
            }
            
            if (inputUnit.equalsIgnoreCase("Q")) {
                // exit the program
                anotherTemp = false;
                System.out.println("Program Ended");
            }
            else {
                validTemp = false;
                do {
                    System.out.print("Enter a valid temperature: ");
                    if (keyInput.hasNextDouble()) {
                        inputTemp = keyInput.nextDouble();
                        if (inputUnit.equalsIgnoreCase("F") && tc1.setTempF(inputTemp)) {
                            tc1.setTempF(inputTemp);
                            System.out.println("The temperature you entered was " + inputTemp + " degrees Fahrenheit.");
                            System.out.println("The equivalent Celsius temperature is " + tc1.getTempC() + " degrees Celsius.");
                            System.out.println("The equivalent Kelvin temperature is " + tc1.getTempK() + " degrees Kelvin.");
                            validTemp = true;
                        }
                        else if (inputUnit.equalsIgnoreCase("C") && tc1.setTempC(inputTemp)) {
                            tc1.setTempC(inputTemp);
                            System.out.println("The temperature you entered was " + inputTemp + " degrees Celsius.");
                            System.out.println("The equivalent Fahrenheit temperature is " + tc1.getTempF() + " degrees Fahrenheit.");
                            System.out.println("The equivalent Kelvin temperature is " + tc1.getTempK() + " degrees Kelvin.");
                            validTemp = true;
                        }
                        else if (inputUnit.equalsIgnoreCase("K") && tc1.setTempK(inputTemp)) {
                            tc1.setTempK(inputTemp);
                            System.out.println("The temperature you entered was " + inputTemp + " degrees Kelvin.");
                            System.out.println("The equivalent Celsius temperature is " + tc1.getTempC() + " degrees Celsius.");
                            System.out.println("The equivalent Fahrenheit temperature is " + tc1.getTempF() + " degrees Fahrenheit.");
                            validTemp = true;
                        }
                        else {
                            System.out.println("The temperature you entered is invalid.");
                            System.out.println("It must be higher than absolute 0 (0K, -273.15C, -459.67F)");
                            System.out.println("Try again.");
                        }
                    }
                    else {
                        System.out.println("You entered an invalid temperature!");
                        System.out.println("It must be a number.");
                        System.out.println("Try again.");
                    }
                    keyInput.nextLine();
                } while ( ! validTemp);
            }
        }
    }
}

