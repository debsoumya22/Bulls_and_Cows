package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String code = "9305";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int cow = 0;
        int bull = 0;

        for(int i = 0; i<input.length();i++){
            if(code.charAt(i) == input.charAt(i)){
                bull = bull+1;
            }
            else if(code.indexOf(input.charAt(i))!=-1){
                cow=cow+1;
            }
        }
        if (bull != 0 && cow != 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.\n",bull,cow,code);
        } else if (bull != 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.\n",bull,code);
        } else if (cow != 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n",cow,code);
        } else {
            System.out.printf("Grade: None. The secret code is %s.\n",code);
        }






    }
}