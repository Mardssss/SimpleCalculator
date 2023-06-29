package org.mardssss;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the expression (e.g., 10+10): ");
        String expression = scanner.nextLine();

        // Find the index of the operator (+, -, *, /, %)
        int operatorIndex = -1;
        char[] operators = {'+', '-', '*', '/','%'};

        for (char operator : operators) {
            operatorIndex = expression.indexOf(operator);
            if (operatorIndex != -1) {
                break;
            }
        }

        if (operatorIndex == -1) {
            System.out.println("Invalid input format");
            return;
        }

        String num1String = expression.substring(0, operatorIndex).trim();
        String num2String = expression.substring(operatorIndex + 1).trim();

        double num1 = Double.parseDouble(num1String);
        char operator = expression.charAt(operatorIndex);
        double num2 = Double.parseDouble(num2String);

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero");
                    return;
                }
                break;
            case '%':
                result = num1 % num2;
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        main(args);
    }
}