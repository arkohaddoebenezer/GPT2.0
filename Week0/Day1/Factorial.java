/**
 * Problem: Implement a function to calculate the factorial of a given number,
 * Pseudo Code:
 * ALGORITHM factorial(n) 
 * BEGIN
 *      IF n == 0 THEN
 *          RETURN 1
 *      ELSE
 *          RETURN n*factorial(n-1)
 *      ENDIF  
 * END
 */

 //implementation
public class Factorial {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
