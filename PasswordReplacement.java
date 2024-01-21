import java.util.Scanner;

public class PasswordReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileContent = scanner.nextLine();
        String result = replacePasswords(fileContent);
        System.out.println(result);
    }

    private static String replacePasswords(String input) {
        return input.replaceAll("code\\d+", "???");
    }
}