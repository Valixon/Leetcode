import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ICPC_D2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        for (int i = 1000; i <= 9999; i++) {
            if (hisobla4(i)) {
                res.add(i);
            }
        }
        System.out.println(res.size());
        System.out.println(res);
    }

    private static boolean hisobla(int num) {
        if (tubmi(num)) return false;
        char[] a = (num + "").toCharArray();
        for (int i = 0; i < a.length; i++) {
            int op = Integer.parseInt((a[i]) + "");
            if (tubmi(op)) return false;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 1]);
            if (tubmi(op)) return false;
        }
        for (int i = 0; i < a.length - 2; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 2]);
            if (tubmi(op)) return false;
        }
        return true;
    }

    private static boolean hisobla4(int num) {
        if (tubmi(num)) return false;
        char[] a = (num + "").toCharArray();
        for (int i = 0; i < a.length; i++) {
            int op = Integer.parseInt((a[i]) + "");
            if (tubmi(op)) return false;
        }
        for (int i = 0; i < a.length - 1; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 1]);
            if (tubmi(op)) return false;
        }
        for (int i = 0; i < a.length - 2; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 2]);
            if (tubmi(op)) return false;
        }
        for (int i = 0; i < a.length - 3; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 3]);
            if (tubmi(op)) return false;
        }

        for (int i = 0; i < a.length - 2; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 1] + "" + a[i + 2]);
            if (tubmi(op)) return false;
        }

        for (int i = 0; i < a.length - 3; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 2] + "" + a[i + 3]);
            if (tubmi(op)) return false;
        }

        for (int i = 0; i < a.length - 3; i++) {
            int op = Integer.parseInt((a[i]) + "" + a[i + 1] + "" + a[i + 3]);
            if (tubmi(op)) return false;
        }
        return true;
    }

    private static boolean tubmi(Integer son) {
        if (son == 0) return false;
        if (son == 1) return false;
        for (int i = 2; i <= Math.sqrt(son); i++) {
            if (son % i == 0) return false;
        }
        return true;
    }
}