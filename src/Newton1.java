import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Compute and print an estimate of a square root from a user input value.
 *
 * @author Nicholas McCracken
 *
 */
public final class Newton1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        /*
         * Initialize values for epsilon and r, or the percent error and square
         * root estimate
         */
        final double percentError = 0.0001;
        double sqrtEstimate = percentError;

        /*
         * Continue loop until r (square root estimate) is within the value of
         * x's by a margin less than the epsilon (percent error)
         */
        while (Math.abs(Math.pow(sqrtEstimate, 2) - x) / x >= Math
                .pow(percentError, 2)) {
            sqrtEstimate = (sqrtEstimate + x / sqrtEstimate) / 2;
        }
        return sqrtEstimate;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        // Declare input and output objects
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // Ask user if they would like to run the program
        out.println("Please enter y if you'd like to calculate a square root, "
                + "or enter anything else to quit: ");
        // Store in choice variable
        String userChoice = in.nextLine();

        // Loop runs if user input string variable equals y, representing yes
        while (userChoice.equals("y")) {
            // Prompt user to enter a value to be squared
            out.print("Please enter a positive value: ");
            // Store value as a double
            double valueToBeSquared = in.nextDouble();

            // Print the user input and it's corresponding square root estimate
            out.println("The square root of " + valueToBeSquared + " is "
                    + sqrt(valueToBeSquared) + ".");

            // Ask user if they would like to continue the program
            out.println("Please enter y to calculate another square root, or"
                    + "enter anything else to quit: ");
            // Store in choice variable
            userChoice = in.nextLine();
        }

        // Close input and output streams
        in.close();
        out.close();
    }
}
