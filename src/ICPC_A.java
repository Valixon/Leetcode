import java.util.Scanner;

public class ICPC_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] a3 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a3[i] = sc.nextInt();
        }
        int res = 0;
        int[] op = new int[500001];
        int[] op12 = new int[500001];
        int[] op23 = new int[500001];
        int[] op13 = new int[500001];
        for (int i = 0; i < n; i++) {
            op[a1[i]]++;
            op[a2[i]]++;
            op[a3[i]]++;

            op12[a1[i]]++;
            op12[a2[i]]++;

            op23[a2[i]]++;
            op23[a3[i]]++;

            op13[a1[i]]++;
            op13[a3[i]]++;

        }
        for (int i = 0; i < n; i++) {
            if (op[a1[i]] == 3) res++;
        }
        if (res >= k) {
            System.out.println(k);
        } else {
            int yetmadi = k - res;
            int res12 = 0;
            for (int i = 0; i < n; i++) {
                if (op12[a1[i]] == 2 && op[a1[i]] != 3) res12++;
            }
            int res23 = 0;
            for (int i = 0; i < n; i++) {
                if (op23[a2[i]] == 2 && op[a2[i]] != 3) res23++;
            }
            int res13 = 0;
            for (int i = 0; i < n; i++) {
                if (op13[a1[i]] == 2 && op[a1[i]] != 3) res13++;
            }
            if (res12 >= yetmadi) {
                res = res + yetmadi * 2;
                System.out.println(res);
            } else if (res23 >= yetmadi) {
                res = res + yetmadi * 2;
                System.out.println(res);
            } else if (res13 >= yetmadi) {
                res = res + yetmadi * 2;
                System.out.println(res);
            } else {
                
            }
        }
    }
}