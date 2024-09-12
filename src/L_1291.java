import java.util.*;

public class L_1291 {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
    }

    public static Set<Integer> all = new TreeSet<>(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789));

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (Integer i : all) {
            if (i < low) continue;
            if (i > high) break;
            res.add(i);
        }
        return res;
    }


}
