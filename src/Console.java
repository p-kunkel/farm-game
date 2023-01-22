import java.util.Scanner;

public class Console {
    public static void Clear() {
        System.out.print("\033[H\033[2J");  
                System.out.flush(); 
    }

    public static String ReadValue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\n> ");
        String value = scan.nextLine();
        return value; 
    }

    public static void ProcessAnyKey(String message) {
        ReadValue();
        Clear();
    }
}
