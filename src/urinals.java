import java.util.Scanner;

/**
 * @author  Omkar Pisal
 * @version 1.0
 * @since   2022-1--27
 */
public class urinals {

    static boolean goodString(String str) {  // checks to see if valid string
        if(str==null||str.length()==0||str.contains(" ")) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Enter String manually\n2. Use File as input");
        int choice = scanner.nextInt();
        if(choice==1){
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }
}
