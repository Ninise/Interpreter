import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Interpreter interpreter = new Interpreter();

        while (true) {
            String line = scanner.nextLine();
            interpreter.parse(line);
        }
    }
}
