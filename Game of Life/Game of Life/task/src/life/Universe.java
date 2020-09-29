package life;

import java.io.IOException;

public class Universe {
    public int[][] state;

    public Universe(int N, long seed) {
        state = Generator.create(N, seed);
    }

    public void evolve(int gen) throws InterruptedException {
        state = Generator.generate(state);

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (InterruptedException | IOException e) {}

        System.out.println("Generation #" + gen);
        System.out.println("Alive: " + this.countAliveCells());
        System.out.println(this.toString());
        java.lang.Thread.sleep(500);
    }

    public int countAliveCells() {
        int alive = 0;
        int L = this.state.length;

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (this.state[i][j] == 1) {
                    alive++;
                }
            }
        }

        return alive;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                sb.append(state[i][j] == 1 ? "O" : " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
