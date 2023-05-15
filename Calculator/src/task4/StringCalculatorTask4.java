package task4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorTask4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by commas: ");
        String input = scanner.next();

        try {
            int result = add(input);
            System.out.println("Sum: " + result);
        } catch (NumberFormatException e) {
        	e.printStackTrace();
            System.out.println("Invalid input. Please enter valid numbers separated by commas.");
        }

        scanner.close();
    }

        public static int add(String numbers) {
            if (numbers.isEmpty()) {
                return 0;
            }

            String delimiter = ",";
            if (numbers.startsWith("//")) {
                int delimiterEndIndex = numbers.indexOf("\\n");
                delimiter = extractDelimiter(numbers.substring(2, delimiterEndIndex));
                numbers = numbers.substring(delimiterEndIndex + 2);
            }

            String[] numArray = numbers.split(delimiter);
            int sum = 0;
            for (String num : numArray) {
                if (!num.isEmpty()) {
                    int value = Integer.parseInt(num);
                    if (value <= 1000) {
                        sum += value;
                    }
                }
            }
            return sum;
        }

        private static String extractDelimiter(String delimiterSubstring) {
            if (delimiterSubstring.startsWith("[")) {
                Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterSubstring);
                if (matcher.find()) {
                    return Pattern.quote(matcher.group(1));
                }
            }
            return Pattern.quote(delimiterSubstring);
        }
    }


