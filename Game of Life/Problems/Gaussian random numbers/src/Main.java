import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        boolean exit = true;

        while (exit) {

            Random random = new Random(k);
            exit = false;

            for (int i = 0; i < n; i++) {
                double number = random.nextGaussian();
                if (number > m) {
                    k++;
                    exit = true;
                    break;
                }
            }

            if (!exit) {
                System.out.println(k);
            }
        }
    }
}