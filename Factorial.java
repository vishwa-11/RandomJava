import java.lang.Throwable;

public class Factorial {

    public static long pureRecursive(int n) {
        long answer;
        //Throwing an error
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        //base case
        if (n == 1) {
            answer = 1;
        }
        //recurrence relation
        else {
            answer = n * pureRecursive(n - 1);
        }

        return answer;

    }
    //throws necessary exception and calls the private tail method
    public static long tailRecursive(int n) throws IllegalAccessException {

        if (n <= 0) {
            throw new IllegalAccessException();
        }
        return tail(n, 1);

    }
    //added an extra field for the answer and then called the method with a multiplication of n times answer
    private static long tail(int n, long answer) {
        //base case
        if (n == 1) {
            return answer;
        }
        //recurrence relation
        else {
            return tail(n - 1, answer * n);
        }

    }

    public static long iterative(int n) {
        long answer = 1;
        int i;
        //throwing an error
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        //basic for loop to iteratively multiply to get a factorial value
        for (i = 1; i <= n; i++) {
            answer = answer * i;
        }
        return answer;
    }
}