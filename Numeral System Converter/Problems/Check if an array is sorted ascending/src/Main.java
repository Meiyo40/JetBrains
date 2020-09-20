import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrSize = scanner.nextInt();
        int[] array = new int[arrSize];
        boolean isSorted = true;
        for (int i = 0; i < arrSize; i++) {
            array[i] = scanner.nextInt();
            if (i > 0) {
                if (array[i-1] > array[i]) {
                    isSorted = false;
                }
            }
        }
        System.out.println(isSorted);
    }
}