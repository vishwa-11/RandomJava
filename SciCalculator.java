import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math;

public class SciCalculator {
    /*
    I first created a method for the main menu that users would operate from. I frequently called this method
    throughout the program.
     */
    public static void menu () {
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");
        System.out.println();
        System.out.print("Enter Menu Selection: ");
    }
    /*
    I then called a scanner and all the variables that I would need for the remainder of the program.
     */
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        double currentResult = 0;
        double operand1;
        double operand2;
        int operation;
        double op1;
        double op2;
        double op3;
        double op4;
        double op5;
        double op6;
        double resultTotal = 0;
        /*
        I created two variables for the total number of calculations but one is of the int class and the other is of
        the double class. The int variable is for the purpose of printing out the number of calculations done while
        the double variable is needed to calculate the value of the average of all results since the average is a
        double variable.
         */
        int numOfCalc = 0;
        double numOfCalcDouble = 0;
        double calcAverage = resultTotal / numOfCalcDouble;

        /*
        This prints the initial Current Result: line and prints the number 0.0. I then print the main menu with the
        menu() method. After that, I called the variable "operation" which is equal to what users input into the
        scanner. The value of operation dictates the rest of the program.
         */
        System.out.print("Current Result: ");
        System.out.println(currentResult);
        System.out.println();

        menu();
        operation = scnr.nextInt();
        //

        /*
        I created a while loop for when the currentResult >= 0, which is all the time, because the only way a user
        should be able to break out of this loop is if he/she gives "operation" a value of 0.
         */
        while (currentResult >= 0) {
            /*
            Within the while loop, I put if/else if statements. If 0 is entered, a statement is printed and the
            while loop is broken.
             */
            if (operation == 0) {
                System.out.println("Thanks for using this calculator. Goodbye!");
                break;
            }
            /*
            If a number 1-6 is entered, then they fall under the following else if statement. I printed the scanners
            for each of the operands and then began the if/else if statements for operations 1-6. At the end of each
            if/else if statement for operations 1-6, I updated the value of the total of all results.
             */
            else if (operation > 0 && operation < 7) {
                System.out.print("Enter first operand: ");
                operand1 = Double.valueOf(scnr.next()).doubleValue();
                System.out.print("Enter second operand: ");
                operand2 = Double.valueOf(scnr.next()).doubleValue();
                System.out.println();
                /*
                operation 1 is for addition.
                 */
                if (operation == 1) {
                    op1 = operand1 + operand2;
                    System.out.println("Current Result: " + op1);
                    System.out.println();
                    resultTotal = resultTotal + op1;
                }
                /*
                operation 2 is for subtraction.
                 */
                else if (operation == 2) {
                    op2 = operand1 - operand2;
                    System.out.println("Current Result: " + op2);
                    System.out.println();
                    resultTotal = resultTotal + op2;
                }
                /*operation 3 is for multiplication.
                 */
                else if (operation == 3) {
                    op3 = operand1 * operand2;
                    System.out.println("Current Result: " + op3);
                    System.out.println();
                    resultTotal = resultTotal + op3;
                }
                /*
                operation 4 is for division.
                 */
                else if (operation == 4) {
                    op4 = operand1 / operand2;
                    System.out.println("Current Result: " + op4);
                    System.out.println();
                    resultTotal = resultTotal + op4;
                }
                /*
                operation 5 is for exponentiation, where I call a function from the Math method that I imported.
                 */
                else if (operation == 5) {
                    op5 = Math.pow(operand1, operand2);
                    System.out.println("Current Result: " + op5);
                    System.out.println();
                    resultTotal = resultTotal + op5;
                }
                /*
                operation 6 is for logarithms, where I call a function from the Math method that I imported.
                 */
                else if (operation == 6) {
                    op6 = Math.log(operand2) / Math.log(operand1);
                    System.out.println("Current Result: " + op6);
                    System.out.println();
                    resultTotal = resultTotal + op6;
                }
                /*
                At the end of these if/else if statements, I update the values of the total number of calculations,
                and average of calculations. I then call the menu() method and the operation scanner.
                 */
                numOfCalc = numOfCalc + 1;
                numOfCalcDouble = numOfCalcDouble + 1;
                calcAverage = resultTotal / numOfCalc;
                menu();
                operation = scnr.nextInt();
            }
            /*
            The following else if statement prints the total of all results, number of calculations, and average of
            calculations before prompting the user to enter another operation. I also limited the value of the Average
            to two decimal places by creating an object of the DecimalFormat class.
             */
            else if (operation == 7) {
                if (numOfCalc > 0) {
                    System.out.println();
                    System.out.println("Sum of calculations: " + resultTotal);
                    System.out.println("Number of calculations: " + numOfCalc);
                    DecimalFormat numberFormat = new DecimalFormat("0.00");
                    System.out.println("Average of calculations: " + numberFormat.format(calcAverage));
                    System.out.println();
                    System.out.print("Enter Menu Selection: ");
                    operation = scnr.nextInt();
                }
                /*
                The following else statement ensures that if operation 7 is entered before any other calculations
                have been made, an error statement is returned and the user is prompted for a valid operation again.
                 */
                else {
                    System.out.println();
                    System.out.println("Error: No calculations yet to average!");
                    System.out.println();
                    System.out.print("Enter Menu Selection: ");
                    operation = scnr.nextInt();
                }
            }


                /*
                The following else statement ensures that if another value outside of 0-7 is inputted, then an
                error statement is outputted and the user is prompted for a valid operation again.
                 */
            else {
                System.out.println();
                System.out.println("Error: Invalid selection!");
                System.out.println();
                System.out.print("Enter Menu Selection: ");
                operation = scnr.nextInt();
            }
            }
        }
    }




