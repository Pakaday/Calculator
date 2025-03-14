import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Input first number: ");
        while (!userInput.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            userInput.next();
        }
        int firstNumber = userInput.nextInt();

        System.out.println("Input second number: ");
        while (!userInput.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            userInput.next();
        }
        int secondNumber = userInput.nextInt();

        System.out.println("Choose your operation (+, -, *, /, %): ");
        char userOperation = userInput.next().charAt(0);

        while (!(userOperation == '+' || userOperation == '-' || userOperation == '*' || userOperation == '/' || userOperation == '%')) {
            System.out.println("Please choose an operation (+, -, *, /, %): ");
            userOperation = userInput.next().charAt(0);
        }

        userInput.close();

        try {
            int result = performOperation(firstNumber, secondNumber, userOperation);
            System.out.println("Answer is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int performOperation(int firstNumber, int secondNumber, char operation) {
        return switch (operation) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> {
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("Divide by zero not allowed");
                }
                yield firstNumber / secondNumber;
            }
            case '%' -> firstNumber % secondNumber;
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }
}