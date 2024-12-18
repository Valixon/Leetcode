import java.util.Scanner;


public class A_Masala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index=0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=9; j++) {
                index++;
                if (index==80){
                    System.out.println(i+" "+j);
                }
            }
        }
        long n = sc.nextLong();
        System.out.println(hisobla(n));
    }

    private static long hisobla(long n) {
        if (n < 10) return n;
        long p = 9;
        while (p < n) {
            n = n - p;
            p = p * 9;
        }

        return n;
    }
}
