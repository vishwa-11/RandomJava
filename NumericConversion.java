import java.util.Scanner;
import java.lang.Math;

/*
The first method I created is for the opening menu, which I repeat often.
 */

public class NumericConversion {
    public static void menu(){
        System.out.println("Decoding Menu");
        System.out.println("------------- ");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println("");
    }
/*
The second method I created is for the conversion of hexadecimal characters to decimal values. I did this by
initializing an integer called decimalValue to 0 and then creating multiple if/else if statements that dictate what
decimalValue will equal given input to the method.
 */

    public static short hexCharDecode(char digit) {
        int decimalValue = 0;
        /*
        The number 0 is taken care of in the next method.
         */
        if (digit == '1') {
            decimalValue = 1;
        }
        else if (digit == '2') {
        decimalValue = 2;
        }
        else if (digit == '3') {
        decimalValue = 3;
        }
        else if (digit == '4') {
        decimalValue = 4;
        }
        else if (digit == '5') {
        decimalValue = 5;
        }
        else if (digit == '6') {
        decimalValue = 6;
        /*
        Most of these else if statements are of identical form.
         */
        }
        else if (digit == '7') {
        decimalValue = 7;
        }
        else if (digit == '8') {
        decimalValue = 8;
        }
        else if (digit == '9') {
        decimalValue = 9;
        }
        /*
        For letters, I had to include an 'or' operator because the program shouldn't be case sensitive.
         */
        else if (digit == 'A' || digit == 'a') {
        decimalValue = 10;
        }
        else if (digit == 'B' || digit == 'b') {
        decimalValue = 11;
        }
        else if (digit == 'C' || digit == 'c') {
        decimalValue = 12;
        }
        else if (digit == 'D' || digit == 'd') {
        decimalValue = 13;
        }
        else if (digit == 'E' || digit == 'e') {
        decimalValue = 14;
        }
        else if (digit == 'F' || digit == 'f') {
        decimalValue = 15;
        }
        /*
        I had to type case the decimalValue variable to the required output variable type.
         */
        return (short) decimalValue;
    }
/*
The next method involves the previous method to be able to convert entire strings of hexadecimal characters.
 */
    public static long hexStringDecode(String hex) {
        /*
        I define decimalValue as a long variable so that the program can process larger values.
         */
        long decimalValue = 0;
        int i;
        int j = 0;
        /*
        A for loop is created that uses an integer i and starts from the largest index value and moves backward.
         */
        for (i = hex.length() - 1; i >= 0; i = i - 1) {
/*
These if and if/else statements ensure that 0 is processed correctly since it is possible that the user types '0x' first.
If 0 is the first character and an x doesn't follow, the 0 is treated normally. Otherwise, it's ignored.
 */
            if (hex.charAt(i) == 0) {
                if (hex.charAt(0) == 0 && hex.charAt(1) == 'x') {
                    decimalValue = decimalValue;
                }
                else {
                    decimalValue = (long) (decimalValue + (0 * (Math.pow(16, j))));
                }
            }
/*
Now, using the previous method, each character is individually processed and added to the decimalValue variable.
Then the value of the exponent, j, is increased by one. After the for loop is finished and we reach index 0, the final
value of decimalValue is returned.
 */
            decimalValue = (long) (decimalValue + (hexCharDecode(hex.charAt(i)) * (Math.pow(16,j))));
            j = j + 1;
        }
        return decimalValue;

    }

/*
The third method converts binary strings to numerical strings.
 */
    public static short binaryStringDecode(String binary) {
        int i;
        int decimalValue = 0;
        int j = 0;
        /*
        A for loop is initialized with similar logic to the previously used for loop. If the first character is a 0
        and the second character is a b, they're ignored. Either way, nothing is added for a zero but the value of
        j, or the exponent, increases by 1.
         */
        for (i = binary.length() - 1; i >= 0; i = i - 1) {

            if (binary.charAt(i) == 0) {
                if (binary.charAt(0) == 0 && binary.charAt(1) == 'b') {
                    decimalValue = decimalValue;
                }
                else {
                    decimalValue = (int) (decimalValue + (0 * (Math.pow(2,j))));
                }
            }
            /*
            If the character is a 1, then 2^j is added to the decimalValue variable. After the length of the string
            is reached, the final value of decimalValue is returned.
             */
            else if (binary.charAt(i) == '1') {
                decimalValue = (int) (decimalValue + (1 * (Math.pow(2,j))));
            }

            j = j + 1;
        }

        return (short) decimalValue;
    }
/*
The final method is a little more complex. I first converted the binary string to a decimal.
 */
    public static String binaryToHex (String binary) {
        long decimalValue = binaryStringDecode(binary);
        String hexa = "";
        String inverseHexa = "";
        int quotient = 0;
        int remainder = 1;
/*
This while loop carries out the conversion of the hexadecimal string to a normal decimal value. After each loop, the
variable inverseHexa is concatenated. The quotient variable is first equated to decimalValue / 16. Since this number
doesn't include the remainder, we can calculate the remainder by subtracting the quotient times 16 from the total
initial number. Since they are integers, there will be a difference. The value of remainder dictates the value added
to inverseHexa. This is repeated after decimalValue is equated to quotient.
 */
        while (quotient >= 0 && remainder > 0) {
            quotient = (int) decimalValue / 16;
            remainder = (int) decimalValue - (quotient * 16);
            if (remainder == 0) {
                inverseHexa = inverseHexa.concat("0");
            }
            else if (remainder == 1) {
                inverseHexa = inverseHexa.concat("1");
            }
            else if (remainder == 2) {
                inverseHexa = inverseHexa.concat("2");
            }
            else if (remainder == 3) {
                inverseHexa = inverseHexa.concat("3");
            }
            else if (remainder == 4) {
                inverseHexa = inverseHexa.concat("4");
            }
            /*
            Most of these else if statements are identical.
             */
            else if (remainder == 5) {
                inverseHexa = inverseHexa.concat("5");
            }
            else if (remainder == 6) {
                inverseHexa = inverseHexa.concat("6");
            }
            else if (remainder == 7) {
                inverseHexa = inverseHexa.concat("7");
            }
            else if (remainder == 8) {
                inverseHexa = inverseHexa.concat("8");
            }
            else if (remainder == 9) {
                inverseHexa = inverseHexa.concat("9");
            }
            /*
            From the number 10, we need to convert the numbers to the letters A through F.
             */
            else if (remainder == 10) {
                inverseHexa = inverseHexa.concat("A");
            }
            else if (remainder == 11) {
                inverseHexa = inverseHexa.concat("B");
            }
            else if (remainder == 12) {
                inverseHexa = inverseHexa.concat("C");
            }
            else if (remainder == 13) {
                inverseHexa = inverseHexa.concat("D");
            }
            else if (remainder == 14) {
                inverseHexa = inverseHexa.concat("E");
            }
            else if (remainder == 15) {
                inverseHexa = inverseHexa.concat("F");
            }
            /*
            This final if statement makes sure that if the quotient is zero after this, then the loop is terminated.
            Note that the quotient will equal 0 in the middle of the loop before the loop terminates one time, so the
            while loop condition sets quotient at greater than or equal to 0.
             */
            if (quotient == 0) {
                remainder = 0;
            }

            decimalValue = quotient;
        }
        /*
        Since inverseHexa is the final answer in reverse, this for loop concatenates the hexa variable in reverse
        so as to invert inverseHexa and get the answer. The while loop gives the inverse of the final inverse so
        this process is necessary. At the end, the hexa value is returned.
         */
            int i;
            for (i = inverseHexa.length() - 1; i >= 0; i = i - 1) {
                String hexaSymbol = String.valueOf(inverseHexa.charAt(i));
                hexa = hexa.concat(hexaSymbol);
            }
            return hexa;
    }


/*
In the main method, I called the menu method and created a while loop.
 */
    public static void main (String [] args) {
        Scanner scnr = new Scanner(System.in);
        menu();
        System.out.print("Please enter an option: ");
        int option = scnr.nextInt();

/*
The while loop works when input for the option variable is within the valid range.
 */
        while (option > 0 && option < 5) {
            /*
            option 1 calls the first method. Options 1 - 3 print the final output.
             */
            if (option == 1) {
                System.out.print("Please enter the numeric string to convert: ");
                String hex = scnr.next();
                System.out.println("Result: " + hexStringDecode(hex));

            }
            /*
            option 2 calls the third method.
             */
            else if (option == 2) {
                System.out.print("Please enter the numeric string to convert: ");
                String binary = scnr.next();
                System.out.println("Result: " + binaryStringDecode(binary));

            }
            /*
            option 3 calls the fourth method.
             */
            else if (option == 3) {
                System.out.print("Please enter the numeric string to convert: ");
                String binary = scnr.next();
                System.out.println("Result: " + binaryToHex(binary));
            }
            /*
            option 4 ends the program.
             */
            else if (option == 4) {
                System.out.println("Goodbye!");
                break;
            }
            /*
            This part of the while loop recalls the menu method to restart the whole loop.
             */
            System.out.println();
            menu();
            System.out.print("Please enter an option: ");
            option = scnr.nextInt();
            }
        }
    }








