import java.util.Scanner; // It will help the user to input values

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true; //A loop that allows users to repeat procedure

        while (keepRunning) {
            // Ask the user to choose the conversion type they want
            System.out.println("Which medium should your temperature be measured in?");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");
            System.out.println("3. Exit");

            // Ask user for their choice
            System.out.print("Enter the number of your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Celsius to Fahrenheit conversion
                    System.out.println("You selected Celsius to Fahrenheit.");
                    double celsius = getValidTemperature(scanner, "Celsius");
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.printf("Dear user, your temperature in Fahrenheit is: %.2f%n", fahrenheit);
                    break;

                case 2:
                    // Fahrenheit to Celsius conversion
                    System.out.println("You selected Fahrenheit to Celsius.");
                    double fahrenheitInput = getValidTemperature(scanner, "Fahrenheit");
                    double celsiusConverted = (fahrenheitInput - 32) * 5 / 9;
                    System.out.printf("Dear user, your temperature in Celsius is: %.2f%n", celsiusConverted);
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Succesfully converted your temperature, Be safe");
                    keepRunning = false;
                    break;

                default:
                    // Tells the user that he or she has given an invalid input
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }

            // Ask if the user wants to continue
            if (keepRunning) {
                System.out.print("Do you want to input another temperature? (yes/no): ");
                String response = scanner.next();
                keepRunning = response.equalsIgnoreCase("yes");
                // This one is a boolean that will ignore the casing for the "yes". it means that, if the user says yes, the programme should continue.
            }
        }

        scanner.close(); 
    }

    // A method to validate the temperature and check extreme values
    public static double getValidTemperature(Scanner scanner, String scale) {
        double temperature = Double.MIN_VALUE;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter your temperature in " + scale + ": ");
                temperature = scanner.nextDouble();

                // Check for extreme temperatures
                if (scale.equalsIgnoreCase("Celsius") && temperature < -273.15) {
                    System.out.println("Temperature below absolute zero is not valid in Celsius!");
                } else if (scale.equalsIgnoreCase("Fahrenheit") && temperature < -459.67) {
                    System.out.println("Temperature below absolute zero is not valid in Fahrenheit!");
                } else {
                    validInput = true; // This is for if Input is valid
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number for temperature.");
                scanner.nextLine(); // this will clear the invalid input
            }
        }

        return temperature;
    }
}
