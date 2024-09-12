import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A0812 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        String res = "";
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        for (int i = 1; i <= 676; i++) {
            String s = sc.next();
            res = res + "\"" + s.substring(s.length() - 2) + s.substring(0, s.length() - 2) + "\", ";
        }
        pw.print(res);
        pw.close();
    }
}