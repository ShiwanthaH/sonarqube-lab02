package main.java.com.example;

public class Calculator {

    // FIXED: Reduced complexity with switch statement
    public int calculate(int a, int b, String op) {
        switch (op) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case "mul":
                return a * b;
            case "div":
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return a / b;
            case "mod":
                return a % b;
            default:
                throw new IllegalArgumentException("Invalid operation: " + op);
        }
    }

    // FIXED: Removed code duplication - single method for addition
    public int add(int a, int b) {
        return a + b;
    }
}
