package Test;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args) {
        double num1 = getDouble();
        double num2 = getDouble();
        char operation = getOperation();
        double result = count(num1,num2,operation);
        System.out.println("Результат операции " + result);
    }
    public static double getDouble () {
        System.out.println("Введите число - ");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку, введите число ");
            scanner.next();
            number = getDouble();
        }
        return number;
    }
    public static char getOperation () {
        System.out.println("Введите знак операции:" + "\n"+"(+) Сложение" + "\n" + "(-) Вычитание"+ "\n" + "(*) Умножение"+ "\n" + "(/) Деление" + "\n" + "(^) Степень");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы ввели недопустимый знак " + scanner.next());
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    public static double count(double num1, double num2, char operation) {
        double powerNum = 1.0;
        for (double i = 1.0; i <= num2; i++) {
            powerNum = powerNum * num1;
        }
        double result;
        switch (operation) {
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
                result = num1 / num2;
                break;
            case '^':
                result = powerNum;
                break;
            default:
                System.out.println("Вы ввели недопустимый знак " + scanner.next());
                result = count(num1,num2,getOperation());
        }
        return result;
    }
}