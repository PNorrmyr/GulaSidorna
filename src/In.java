import java.util.Scanner;

public abstract class In {

    private static final Scanner scanner = new Scanner(System.in);


    public static int scannerInt(){
        return Integer.parseInt(scanner.nextLine());
    }

    public static String scannerString(){
        return scanner.nextLine();
    }

}
