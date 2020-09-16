import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        int max = 0;
        int index = 0;

        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }

        System.out.println(index);
    }
}