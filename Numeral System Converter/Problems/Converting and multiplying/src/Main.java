import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        List<String> inputList = new ArrayList<>();

        while (run) {
            String input = scanner.next();
            if (input.equals("0")) {
                run = false;
            } else {
                inputList.add(input);
            }
        }

        for (String s : inputList) {
            try {
                System.out.println(Integer.parseInt(s) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + s);
            }
        }
    }
}