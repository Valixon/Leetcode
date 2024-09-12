//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class N_TUB {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long n = sc.nextLong();
//        System.out.println(n / Math.log(n));
//        System.out.println(count(n));
//        List<Integer> a = Atkin(Integer.parseInt(String.valueOf(n)));
//        System.out.println(a.size());
////        for (int i = 0; i < a.size(); i++) {
////            System.out.println(i + 1 + " " + a.get(i));
////        }
//    }
//
//    private static long count(long x) {
//        if (x < 6) {
//            if (x < 2) {
//                return 0;
//            }
//            return 5;
//        }
//    long root2 = (long) (Math.sqrt(x));
//    long root3 = (long)(x * 0.33333* 0.33333);
//    long top = (long)(x / root3) + 1;
//    long {primes, pi} = soeCalc(top + 2);
//    long a = pi[root3 + 1], b = pi[root2 + 1];
//        let sum = 0;
//        for (let i = a; i < b; ++i) {
//        const p = primes[i];
//            sum += pi[Math.floor(x / p)] - pi[p] + 1;
//        }
//        return Phi(x, a, primes) + a - 1 - sum;
//    }
//
//    public static List<Integer> Atkin(int limit) {
//        int x2 = 0, y2 = 0, n = 0;
//        int sqrtLim = (int) (Math.sqrt((limit)));
//        boolean[] arr = new boolean[limit + 1];
//        arr[2] = true;
//        arr[3] = true;
//
//        for (int i = 1; i <= sqrtLim; i++) {
//            x2 = i * i;
//            for (int j = 1; j <= sqrtLim; j++) {
//                y2 = j * j;
//                n = 4 * x2 + y2;
//
//                if ((n <= limit) && (n % 12 == 1 || n % 12 == 5)) {
//                    arr[n] = !arr[n];
//                }
//
//                n -= x2;
//                if ((n <= limit) && (n % 12 == 7)) {
//                    arr[n] = !arr[n];
//                }
//
//                n -= 2 * y2;
//                if ((i > j) && (n <= limit) && (n % 12 == 11)) {
//                    arr[n] = !arr[n];
//                }
//            }
//        }
//
//        for (int i = 5; i <= sqrtLim; i++) {
//            if (arr[i]) {
//                n = i * i;
//                for (int j = n; j <= limit; j += n) {
//                    arr[j] = false;
//                }
//            }
//        }
//
//        List<Integer> primes = new ArrayList<>();
//        for (int i = 1; i < limit; i++) {
//            if (i > 1 && arr[i]) {
//                primes.add(i);
//            }
//        }
//
//        return primes;
//    }
//
//}
