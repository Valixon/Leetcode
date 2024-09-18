import java.util.Arrays;

public class L_179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0, 0}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{34323, 3432}));
    }

    public static String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = "" + nums[i];
        }
        Arrays.sort(s, (s1, s2) -> salom(s1, s2));
        System.out.println(Arrays.toString(s));
        StringBuilder res = new StringBuilder();
        for (String num : s)
            res.append(num);
        while (res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }

    private static int salom(String s1, String s2) {
        if (s2.equals(s1)) return 0;
        if (s2.startsWith(s1)) {
            return salom(s2.substring(s1.length()), s1);
        }
        if (s1.startsWith(s2)) {
            return salom(s1.substring(s2.length()), s2);
        }
        return s2.compareTo(s1);
    }
}