import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
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

    public  String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        if(fileURL != null)
        {
            File file = new File(fileURL.getFile());
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.lineSeparator());
            }

        }
        return sb.toString();

    }

    public static void main(String[] args) throws IOException {
        urinals url = new urinals();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Enter String manually\n2. Use File as input");
        int choice = scanner.nextInt();
        if(choice==1){
            System.out.println("Enter String of 0s and 1s");
            String str = scanner.next();
            if (urinals.goodString(str)){
                System.out.println("Empty Urinals:"+urinals.countUrinals(str));
            } else {
                System.out.println("Invalid Input String!");
            }

        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String[] str = url.readFile().split(System.lineSeparator());
            for (String s: str){
                stringBuilder.append(urinals.countUrinals(s)+ System.lineSeparator());
            }
            Path path = Paths.get("resources/rule.txt");
            try {
                Files.write(path, Collections.singleton(stringBuilder.toString()),
                        StandardCharsets.UTF_8);
                System.out.println("Output Successfully Generated!");
            }
            // Catch block to handle the exception
            catch (IOException ex) {
                System.out.print("Invalid Path");
            }
        }
    }
}
