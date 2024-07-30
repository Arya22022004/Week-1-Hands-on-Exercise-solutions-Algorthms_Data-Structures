/*
 Recursion: 
 ->Recursion is a programming technique where a function calls itself repeatedly until it reaches a base case that stops the recursion.
 ->Recursion can simplify certain problems by breaking them down into smaller sub-problems.
 */



import java.util.*;

public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the growth rate (as a decimal): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(presentValue, growthRate, years);

        System.out.println("The future value is: " + futureValue);

        scanner.close();
    }
}

/*
 Time Complexity: 
 * The time complexity of the recursive algorithm is O(n), where n is the number of years. 
 * This is because the algorithm makes n recursive calls to calculate the future value.
 */