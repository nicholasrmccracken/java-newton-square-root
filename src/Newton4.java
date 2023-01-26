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
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     * @param epsilon
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        /*
         * Initialize values for epsilon and r, or the percent error and square
         * root estimate
         */
        double sqrtEstimate = epsilon;

        /*
         * Check to see if x is not zero before calculating the square root to
         * ensure program does not attempt to divide by zero
         */
        if (x != 0) {
            /*
             * Continue loop until r (square root estimate) is within the value
             * of x's by a margin less than the epsilon (percent error)
             */
            while (Math.abs(Math.pow(sqrtEstimate, 2) - x) / x >= Math
                    .pow(epsilon, 2)) {
                sqrtEstimate = (sqrtEstimate + x / sqrtEstimate) / 2;
            }
        } else {
            // Set the square root estimate equal to x if x is zero
            sqrtEstimate = x;
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
        // Declare on/off lever for while loop of square root calculations
        boolean sqrtCalculatorLever = true;

        /*
         * While loop prompts user for values to calculate square roots, and
         * runs indefinitely until a negative value is input by the user.
         * General intelligence is assumed, meaning if user opens program they
         * intend to use it at least once.
         */
        while (sqrtCalculatorLever) {
            // Prompt user to enter a value to be squared
            out.print("Please enter a positive value: ");
            // Store value as a double
            double valueToBeSquared = in.nextDouble();

            if (valueToBeSquared >= 0) {
                // Prompt user to enter a value for the percent error
                out.print("Please enter a percent error decimal value: ");
                // Store value as a double
                double percentError = in.nextDouble();

                /*
                 * Print the user input and it's corresponding square root
                 * estimate
                 */
                out.println("The square root of " + valueToBeSquared + " is "
                        + sqrt(valueToBeSquared, percentError) + ".");
                out.println("");
            } else {
                // Turn while loop off if user input value is negative
                sqrtCalculatorLever = false;
            }
        }
        // Close input and output streams
        in.close();
        out.close();
    }
}
