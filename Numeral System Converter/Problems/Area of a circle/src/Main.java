import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rad = scanner.nextDouble();
        double area = Math.pow(rad, 2) * Math.PI;
        System.out.println(area);
    }
}