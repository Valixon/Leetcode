import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class L_3043 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1124, 9304, 8119}, new int[]{7782, 3372, 9864}));
        System.out.println(longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4}));
        System.out.println(longestCommonPrefix(new int[]{123, 234, 3567}, new int[]{12345, 234, 35678}));
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> ss1 = new TreeSet<>();
        Set<Integer> ss2 = new TreeSet<>();
        for (int num : arr1) {
            while (num > 0) {
                ss1.add(num);
                num /= 10;
            }
        }
        for (int num : arr2) {
            while (num > 0) {
                ss2.add(num);
                num /= 10;
            }
        }
        List<Integer> birinchi = new ArrayList<>();
        List<Integer> ikkichi = new ArrayList<>();
        birinchi.add(0);
        boolean bor = true;
        while (bor) {
            bor = false;
            for (Integer num : birinchi) {
                num = num * 10;
                for (int i = 0; i < 10; i++) {
                    int qurt = num + i;
                    if (ss1.contains(qurt) && ss2.contains(qurt)) {
                        ikkichi.add(qurt);
                        bor = true;
                    }
                }
            }
            if (bor) {
                birinchi = new ArrayList<>(ikkichi);
                ikkichi = new ArrayList<>();
            }
        }
        if (birinchi.get(0) == 0) return 0;
        return ("" + birinchi.get(0)).length();
    }
}