package util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> commandInput() {
        System.out.println("Enter command (enter help to see list of commands): ");
        System.out.print("> ");
        String strInput = scanner.nextLine();
        return Arrays.asList(strInput.split(" "));
    }
}
