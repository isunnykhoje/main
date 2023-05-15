package task1;

import java.util.Scanner;

public class StringCalculatorTask1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by commas: ");
        String input = scanner.nextLine();

        try {
            int result = add(input);
            System.out.println("Sum: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers separated by commas.");
        }

        scanner.close();
    }

    public static int add(String numbers) throws NumberFormatException {
    	
    	String input= numbers.replace("\"", "");
        if (input == null || input.isEmpty()) {
        	
            return 0;
        }

        String[] tokens = input.split(",");

        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        if (tokens.length == 2) {
            int sum = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
            return sum;
        }

        throw new IllegalArgumentException("Input must contain 0, 1, or 2 numbers separated by commas.");
    }
}
