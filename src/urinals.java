import java.util.Scanner;

/**
 * @author  Omkar Pisal
 * @version 1.0
 * @since   2022-1--27
 */
public class urinals {

    public static boolean goodString(String str) {  // checks to see if valid string
        if(str==null||str.length()==0||str.length()>=21||str.contains(" ")){
            return false;
        }
        for (int i=0; i<str.length()-1;i++){
            if (str.charAt(i)=='1' && str.charAt(i+1)=='1') {
                return false;
            }
        }
        return true;
    }

    public static int countUrinals(String str)
    {
        StringBuilder stringBuilder = new StringBuilder(str);
        int emptyUrinals = 0;
        if(stringBuilder.charAt(0) == '0' && stringBuilder.charAt(1) == '0') {
            stringBuilder.setCharAt(0, '1');
            emptyUrinals = emptyUrinals + 1;
        }
        for(int i = 1; i< str.length() -1; i++)
        {
            if(stringBuilder.charAt(i-1) == '0' && stringBuilder.charAt(i) == '0' &&
                    stringBuilder.charAt(i+1) == '0')
            {
                stringBuilder.setCharAt(i, '1');
                emptyUrinals = emptyUrinals + 1;
            }
        }
        if(stringBuilder.charAt(stringBuilder.length()-1) == '0' && stringBuilder.charAt(stringBuilder.length()-2) == '0')
        {
            stringBuilder.setCharAt(stringBuilder.length()-1, '1');
            emptyUrinals = emptyUrinals +1;
        }
        return emptyUrinals;
    }

    public static void main(String[] args) {
        System.out.println(urinals.goodString("0101100"));
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
