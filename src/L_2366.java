import java.util.Scanner;

public class L_2366 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(minimumReplacement(a));
    }

    public static long minimumReplacement(int[] nums) {
        long result = 0;
        int n = nums.length;
        int x = 0, a, b;
        for (int i = n - 1; i >= 1; i--) {
            a = nums[i];
            b = nums[i - 1];
            if (a < b) {
                x = ((b - 1) / a);
                result += x;
                if ((b) % a == 0) {
                    nums[i - 1] = a;
                } else {
                    nums[i - 1] = (b) / (x + 1);
                }
            }
        }
        return result;
    }
}

//[368 112 2 282 349 127,36,98,371,79,309,221,175,262,224,215,230,250,84,269,384,328,118,97,17,105,342,344,242,160,394,17,120,335,76,101,260,244,378,375,164,190,320,376,197,398,353,138,362,38,54,172,3,300,264,165,251,24,312,355,237,314,397,101,117,268,36,165,373,269,351,67,263,332,296,13,118,294,159,137,82,288,250,131,354,261,192,111,16,139,261,295,112,121,234,335,256,303,328,242,260,346,22,277,179,223]