package life;

import java.util.Random;

public class MapGenerator {
    public int size;
    public int seed;
    protected boolean[][] Map;

    public MapGenerator(int size, int seed) {
        this.size = size;
        this.seed = seed;
        this.Map = new boolean[size][size];
        this.createMap();
    }

    public void createMap() {
        Random random = new Random(this.seed);
        for (int i = 0; i < this.size; i++) {
            for (int j  = 0; j < this.size; j++) {
                this.Map[i][j] = random.nextBoolean();
            }
        }
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            for (int j  = 0; j < this.size; j++) {
                if(this.Map[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\r");
        }
    }
}
