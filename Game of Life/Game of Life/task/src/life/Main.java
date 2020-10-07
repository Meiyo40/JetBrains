package life;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isValidEntry = false;
        while (!isValidEntry) {
            try {

                GameOfLife game = new GameOfLife();
                int n, g;
                long s = 500;
                n = Integer.parseInt(in.next());
                //s = Long.parseLong(in.next());
                //g = Integer.parseInt(in.next());
                g = 100;
                if (n > 0 && g >= 0) isValidEntry = true;
                if (isValidEntry) {
                    Universe world = new Universe(n, s);
                    game.setWorld(world);
                    int i = 1;
                    while (i < g+1) {
                        game.refresh();
                        i++;
                    }
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("Invalid entry, try again.");
            }
        }
    }
}
