import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scan.nextInt();
        }
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean nextTo = false;
        for (int j = 0; j < len - 1; j++) {
            if (array[j] == n && array[j + 1] == m || array[j] == m && array[j + 1] == n) {
                nextTo = true;
                break;
            }
        }
        System.out.println(nextTo);
    }
}
