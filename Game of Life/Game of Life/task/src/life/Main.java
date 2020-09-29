package life;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isValidEntry = false;
        while (!isValidEntry) {
            try {
                int n, g;
                long s;
                n = Integer.parseInt(in.next());
                //s = Long.parseLong(in.next());
                //g = Integer.parseInt(in.next());
                g = 10;
                if (n > 0 && g >= 0) isValidEntry = true;
                if (isValidEntry) {
                    Universe u = new Universe(n, 500);
                    for (int i = 1; i < g+1; i++) {
                        u.evolve(i);
                    }
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.out.println("Invalid entry, try again.");
            }
        }
    }
}
