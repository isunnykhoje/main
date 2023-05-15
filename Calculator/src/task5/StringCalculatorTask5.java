package task5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringCalculatorTask5 {

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

    public static int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split("[,\n]");

        List<Integer> negatives = Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .map(Integer::parseInt)
                .filter(num -> num < 0)
                .collect(Collectors.toList());

        if (!negatives.isEmpty()) {
            String negativeNumbers = negatives.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));

            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        int sum = Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(num -> num <= 1000)
                .sum();

        return sum;
    }

}
