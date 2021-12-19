import java.util.Scanner;

public class Calculator {
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        /* We need to declare the variables for the numbers
        and the operations used.
         */
        double operand1;
        double operand2;
        int operation;
        double op1;
        double op2;
        double op3;
        double op4;
        /* Now we need to ask for the operands.
        We also need to change the acceptable variable type
        of the scanner from string to double.
         */
        System.out.print("Enter first operand: ");
        operand1 = Double.valueOf(scnr.next()).doubleValue();
        System.out.print("Enter second operand: ");
        operand2 = Double.valueOf(scnr.next()).doubleValue();
        op1 = operand1 + operand2;
        op2 = operand1 - operand2;
        op3 = operand1 * operand2;
        op4 = operand1 / operand2;
        /* Now we provide choices for the operations.
        We also have to change the acceptable variable type
        of the scanner from string to integer.
         */
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Which operation do you want to perform? ");
        //
        operation = Integer.valueOf(scnr.next()).intValue();
        /* We should now create if statements that perform
        operations or print statements based on the operation input.
         */
        if (operation == 1) {
            System.out.println("The result of the operation is " + op1 + ". Goodbye!");
        }
        else if (operation == 2) {
            System.out.println("The result of the operation is " + op2 + ". Goodbye!");
        }
        else if (operation == 3) {
            System.out.println("The result of the operation is " + op3 + ". Goodbye!");
        }
        else if (operation == 4) {
            System.out.println("The result of the operation is " + op4 + ". Goodbye!");
        }
        else {
            System.out.print("Error: Invalid selection! Terminating program.");
        }
    }
}
