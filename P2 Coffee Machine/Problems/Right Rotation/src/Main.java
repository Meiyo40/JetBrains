import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String array = scanner.nextLine();
        String[] newArray = array.split(" ");
        String[] copyArray = newArray;
        int rotation = scanner.nextInt();
        rotation = rotation % newArray.length;

        for (int i = 0; i < rotation; i++) {
            String last;
            last = newArray[newArray.length-1];

            for (int j = newArray.length-1; j > 0; j--) {
                copyArray[j] = copyArray[j-1];
            }
            copyArray[0] = last;
        }

        for (int i = 0; i < copyArray.length; i++) {
            System.out.print(copyArray[i] + " ");
        }


    }
}