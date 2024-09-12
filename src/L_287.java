import java.util.Scanner;

public class L_287 {
    private static boolean[] bordimi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i] = sc.nextInt();
            }
        }

        System.out.println(findDuplicate(a));
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        boolean[] chiqdimi = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (chiqdimi[nums[i]]) {
                return nums[i];
            }
            chiqdimi[nums[i]] = true;
        }
        return 0;
    }
}

/*
6
1
    1
3
    0 2 4
2
    1 3
1
    2
2
    1 5
1
    4


5
4
1 2 3 4
1
0
1
0
1
0
1
0

5
1
1
3
0 2 4
3
1 3  4
1
2
2
1 2




 */

