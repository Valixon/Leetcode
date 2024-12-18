import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ICPC_D {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        long res = 5;
//        for (int i = 1; i < n; i++) {
//            res = ((res * 72)/3) % 998244353L;
//        }
//        System.out.println(res);
//    }
//}

        List<Integer> a = List.of(new Integer[]{10, 14, 16, 18, 40, 44, 46, 48, 49, 60, 64, 66, 68, 69, 80, 81, 84, 86, 88, 90, 91, 94, 96, 98, 99});
//        a.add(1);
//        a.add(4);
//        a.add(6);
//        a.add(8);x
//        a.add(9);
        List<Integer> b = new ArrayList<>();
        b.add(0);
        b.add(1);
        b.add(4);
        b.add(6);
        b.add(8);
        b.add(9);
        List<Integer> yangi = new ArrayList<>();
        List<Integer> tub = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (Integer son : a) {
                for (Integer qo : b) {
                    int lol = son * 10 + qo;
                    int op = ((int) son / 10) * 10 + qo;
                    int op2 = ((int) son % 10) * 10 + qo;
                    if (!tubmi(lol) && !tubmi(op) && !tubmi(op2)) {
                        yangi.add(lol);
                    }else {
                        tub.add(lol);
                    }
                }
            }
            a = new ArrayList<>(yangi);
            System.out.println(a.size());
            System.out.println(a);
            System.out.println(tub);
            System.out.println();
            yangi = new ArrayList<>();
            tub = new ArrayList<>();
        }
    }

    private static boolean tubmi(Integer son) {
        if (son==0) return false;
        for (int i = 2; i <= Math.sqrt(son); i++) {
            if (son % i == 0) return false;
        }
        return true;
    }
}