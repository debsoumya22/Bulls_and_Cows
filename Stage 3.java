package bullscows;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        if (len > 10) {
            System.out.printf("Error: can't generate a secret number with " +
                    "a length of %d because there aren't enough unique digits.", len);
            System.exit(0);
        }
        StringBuilder code = new StringBuilder();
        long num;

        long pseudoRandomNumber = 0;
        do {
            if (pseudoRandomNumber == 0)
                pseudoRandomNumber = System.nanoTime();
            num = pseudoRandomNumber % 10;
            pseudoRandomNumber = pseudoRandomNumber / 10;
            if ((code.length() == 0 && num == 0)) {
                continue;
            }
            if (-1 == code.indexOf(String.valueOf(num)))
                code.append(num);
        } while (code.length() < len);


        System.out.printf("The random secret number is %s.", code);
    }
}