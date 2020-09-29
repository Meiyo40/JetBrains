import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] val = getVal();
        int MIN_SEED = val[0];
        int MAX_SEED = val[1];
        int ITERATION = val[2];
        int RANGE = val[3];
        Integer[][] values = new Integer[MAX_SEED+1][ITERATION];
        for (int i = MIN_SEED; i < MAX_SEED + 1; i++) {
            Random rand = new Random(i);
            for (int j = 0; j < ITERATION; j++) {
                int rnd = rand.nextInt(RANGE);
                values[i][j] = rnd;
                //System.out.println("Index("+i+":"+RANGE+") nb = "+rnd);
            }
            Arrays.sort(values[i], Collections.reverseOrder());
        }
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = MIN_SEED; i < MAX_SEED; i++) {
            int nb = Math.min(values[i][0], values[i+1][0]);

            if (nb < min) {
                min = nb;
                min_index = nb == values[i][0] ? i : i+1;
            }
        }

        System.out.println(min_index + "\n" + min);

    }

    public static int[] getVal() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] input_explode = input.split(" ");
        int[] val = new int[4];
        for (int i = 0; i < input_explode.length; i++) {
            val[i] = Integer.parseInt(input_explode[i]);
        }
        return val;
    }
}