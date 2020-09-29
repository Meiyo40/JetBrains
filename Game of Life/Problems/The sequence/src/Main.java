import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        int input = Integer.parseInt(inputStr);
        doCode(input);
    }

    public static void doCode(int nb) {
        int val = 0, i = 0;
        while ( i < nb ) {
            val++;
            for (int j = 0; j < val; j++) {
                if (i < nb) {
                    System.out.print(val + " ");
                    i++;
                } else {
                    break;
                }
            }
        }
    }
}