package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String secretCode = generateSecretCode();
        if (secretCode.isEmpty()) {
            return;
        }
        int bulls = 0;
        int cows = 0;
        int turn = 1;
        System.out.println("Okay, let's start a game!");
        while (bulls != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            System.out.print("> ");
            String input = scanner.nextLine();
            bulls = countBulls(secretCode, input);
            cows = countCows(secretCode, input);
            printResult(bulls, cows, Integer.parseInt(secretCode));
            turn++;
        }
        if (bulls == secretCode.length()) {
            System.out.println("Congratulations! You guessed the secret code.");
        }
        scanner.close();
    }

    public static void printResult(int bulls, int cows, int code) {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (bulls > 0 && cows > 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (cows > 0) {
            System.out.println("Grade: " + cows + " cow(s).");
        } else if (bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        }
    }

    public static int countBulls(String code, String input) {
        int bulls = 0;
        for(int i = 0; i<input.length();i++){
            if(code.charAt(i) == input.charAt(i)){
                bulls = bulls+1;
            }
        }

        return bulls;
    }

    public static int countCows(String code, String input) {
        int cows = 0;
        for (int i = 0; i < input.length(); i++) {
            char inputDigit = input.charAt(i);
            int idx = code.indexOf(inputDigit);
            if (idx == -1) {
                continue;
            }
            if (idx != i && code.contains(String.valueOf(inputDigit))) {
                cows++;
            }
        }
        return cows;
    }

    public static String generateSecretCode() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        StringBuilder num = new StringBuilder();

        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        } else {
            while (num.length() < length) {
                int digit = (int)(Math.random()*10);
                if(!num.toString().contains(String.valueOf(digit))){
                    num.append(digit);
                }

            }
            num = num.charAt(0) == '0' ? num.reverse() : num;
        }
        return num.toString();


    }
}