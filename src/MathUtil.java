public class MathUtil {

    // 5 Static Methods

    /**
     * Determines if a number is prime or not.
     * A prime number is only divisible by 1 and itself.
     * @param a The number to verify.
     * @return true if a is a prime number, false otherwise.
     */
    public static boolean checkPrime(int a) {
        if (a < 2) return false; // Any number less than 2 is not prime
        for (int i = 2; i <= Math.sqrt(a); i++) { // Check divisibility from 2 to √a
            if (a % i == 0) return false; // If divisible by any number, not prime
        }
        return true; // Otherwise, the number is prime
    }

    /**
     * Uses the Euclidean algorithm to find the greatest common divisor (GCD) of two numbers.
     * The GCD is the largest integer that divides both numbers without a remainder.
     * @param x First number.
     * @param y Second number.
     * @return The greatest common divisor (GCD) of x and y.
     */
    public static int computeGCD(int x, int y) {
        while (y != 0) { // Repeat until y becomes 0
            int temp = y;
            y = x % y; // Replace y with the remainder
            x = temp;
        }
        return x; // When y is 0, x contains the GCD
    }

    /**
     * Calculates the least common multiple (LCM) of two integers.
     * LCM is the smallest number that is a multiple of both numbers.
     * @param x First integer.
     * @param y Second integer.
     * @return The least common multiple of x and y.
     */
    public static int findLCM(int x, int y) {
        return Math.abs(x * y) / computeGCD(x, y); // Use the formula: |x * y| / GCD(x, y)
    }

    /**
     * Generates the nth Fibonacci number.
     * The Fibonacci sequence starts with 0, 1 and the subsequent number is the sum of the previous two.
     * @param a Position in the Fibonacci sequence.
     * @return The Fibonacci number at position a.
     */
    public static int getFibonacci(int a) {
        if (a == 0) return 0; // Base case: Fibonacci(0) = 0
        if (a == 1) return 1; // Base case: Fibonacci(1) = 1
        int prev1 = 0, prev2 = 1, fib = 1;
        for (int i = 2; i <= a; i++) {
            fib = prev1 + prev2; // Calculate the next number in the sequence
            prev1 = prev2;
            prev2 = fib;
        }
        return fib; // Return the nth Fibonacci number
    }

    /**
     * Computes the factorial of a given number.
     * Factorial of n is the product of all integers from 1 to n.
     * @param a The number to calculate the factorial for.
     * @return The factorial of a.
     */
    public static long calculateFactorial(int a) {
        long result = 1; // Initialize result to 1 (factorial of 0 is 1)
        for (int i = 2; i <= a; i++) { // Multiply all integers from 2 to a
            result *= i;
        }
        return result; // Return the factorial of a
    }

    // 5 Non-static Methods

    /**
     * Verifies whether a number is perfect.
     * A perfect number is equal to the sum of its divisors (excluding itself).
     * @param a The number to verify.
     * @return true if a is a perfect number, false otherwise.
     */
    public boolean isPerfect(int a) {
        int divisorSum = 1; // Initialize with 1 since it's a divisor for every number
        for (int i = 2; i <= Math.sqrt(a); i++) { // Check divisors up to √a
            if (a % i == 0) { // If i is a divisor, add it to the sum
                divisorSum += i;
                if (i != a / i) { // Avoid adding square roots twice
                    divisorSum += a / i;
                }
            }
        }
        return divisorSum == a && a != 1; // Check if sum of divisors equals the original number
    }

    /**
     * Sums the digits of a number.
     * @param a The number whose digits are to be summed.
     * @return The sum of the digits of a.
     */
    public int digitSum(int a) {
        int sum = 0;
        while (a > 0) { // Iterate through each digit
            sum += a % 10; // Add the last digit to the sum
            a /= 10; // Remove the last digit
        }
        return sum; // Return the sum of the digits
    }

    /**
     * Reverses the digits of a number.
     * @param a The number to reverse.
     * @return The reversed number.
     */
    public int reverseDigits(int a) {
        int reversed = 0;
        while (a != 0) { // Process until all digits are reversed
            reversed = reversed * 10 + a % 10; // Append the last digit
            a /= 10; // Remove the last digit
        }
        return reversed; // Return the reversed number
    }

    /**
     * Determines whether a number is an Armstrong number.
     * An Armstrong number is equal to the sum of its digits raised to the power of the number of digits.
     * @param a The number to check.
     * @return true if a is an Armstrong number, false otherwise.
     */
    public boolean isArmstrong(int a) {
        int sum = 0, original = a;
        int digitsCount = String.valueOf(a).length(); // Find the number of digits
        while (a > 0) {
            sum += Math.pow(a % 10, digitsCount); // Add each digit raised to the power of digitsCount
            a /= 10; // Remove the last digit
        }
        return sum == original; // Return true if sum equals the original number
    }

    /**
     * Finds the next prime number greater than the given number.
     * @param a The number to start from.
     * @return The next prime number greater than a.
     */
    public int nextPrime(int a) {
        a++; // Start from the next number
        while (!checkPrime(a)) { // Keep checking until the next prime is found
            a++;
        }
        return a; // Return the next prime number
    }

    // Main method for testing the MathUtility class functionality
    public static void main(String[] args) {
        // Testing static methods
        System.out.println("Testing Static Methods:");
        System.out.println("Is 13 a prime number? " + checkPrime(13)); // Expected: true
        System.out.println("GCD of 56 and 98: " + computeGCD(56, 98)); // Expected: 14
        System.out.println("LCM of 8 and 12: " + findLCM(8, 12)); // Expected: 24
        System.out.println("The 10th Fibonacci number: " + getFibonacci(10)); // Expected: 55
        System.out.println("Factorial of 6: " + calculateFactorial(6)); // Expected: 720

        // Testing non-static methods
        MathUtility mathUtil = new MathUtility();
        System.out.println("\nTesting Non-static Methods:");
        System.out.println("Is 496 a perfect number? " + mathUtil.isPerfect(496)); // Expected: true
        System.out.println("Sum of digits in 9876: " + mathUtil.digitSum(9876)); // Expected: 30
        System.out.println("Reversed number of 1234: " + mathUtil.reverseDigits(1234)); // Expected: 4321
        System.out.println("Is 370 an Armstrong number? " + mathUtil.isArmstrong(370)); // Expected: true
        System.out.println("Next prime number after 17: " + mathUtil.nextPrime(17)); // Expected: 19
    }
}
