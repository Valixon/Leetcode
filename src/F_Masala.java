import java.util.Scanner;


public class F_Masala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        int u1 = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3, 5));
        String s2 = sc.next();
        int n = sc.nextInt();
        int u2 = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(3, 5)) - (n * 60);
        while (u2 <= u1) {
            u2 = u2 + (24 * 60);
        }
        int y = (u2 - u1) % (48 * 60);
        int hh = y / 60;
        int mm = y % 60;
        System.out.print(hh < 10 ? "0" + hh : hh);
        System.out.print(":");
        System.out.print(mm < 10 ? "0" + mm : mm);
    }

}
