import java.util.Scanner;

public class L_1512 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1,1,1,1}));
        System.out.println(numIdenticalPairs(new int[]{1,2,3}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] a = new int[101];
        for (int num : nums) {
            a[num]++;
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + ((a[i] * (a[i] - 1)) / 2);
        }
        return sum;
    }
}
