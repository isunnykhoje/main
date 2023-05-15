package task2;

import java.util.Scanner;

public class StringCalculatorTask2 {

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

   
        public static int add(String numbers)throws NumberFormatException {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                String[] numArray = numbers.split(",");
                int sum = 0;
                for (String num : numArray) {
                    sum += Integer.parseInt(num);
                }
                return sum;
            }
        }

		

}
