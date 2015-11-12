import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       
        Scanner scanner = new Scanner(System.in);

        Interpreter interpreter = new Interpreter();

        while (true) {
            String line = scanner.nextline();            
            interpreter.parse(line);
        }       
    }
}
