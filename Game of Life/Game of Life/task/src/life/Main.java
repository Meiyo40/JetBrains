package life;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        MapGenerator Map = new MapGenerator(width, height);
        Map.display();
    }
}
