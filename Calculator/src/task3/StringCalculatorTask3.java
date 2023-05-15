package task3;

import java.util.Scanner;

public class StringCalculatorTask3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by commas: ");
        String input = scanner.next();

        try {
            int result = add(input);
            System.out.println("Sum: " + result);
        } 
        
        catch (NumberFormatException e) {
        	e.printStackTrace();
            System.out.println("Invalid input. Please enter valid numbers separated by commas.");
        }

        scanner.close();
    }

   
        public static int add(String numbers) {
            if (numbers.isEmpty()) {
                return 0;
            } else {
                
                String replacedNumbers = numbers.replaceAll("\\\\n", ",");
                String[] numArray = replacedNumbers.split(",|\n");
              
                int sum = 0;
                for (String num : numArray) {
                    if (!num.isEmpty()) {
                        sum += Integer.parseInt(num);
                    }
                }
                return sum;
            }
        }

    }


