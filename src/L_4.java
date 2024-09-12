import java.util.Arrays;
import java.util.Scanner;

public class L_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        return nums;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int x = (n + m + 1) / 2;
        int y = (n + m + 2) / 2;
        if (n == 0) {
            return (double) (nums2[x - 1] + nums2[y - 1]) / 2;
        }
        if (m == 0) {
            return (double) (nums1[x - 1] + nums1[y - 1]) / 2;
        }
        int index1 = 0;
        int index2 = 0;
        int m1 = 0, m2 = 0;
        for (int i = 1; i <= y; i++) {
            if (nums1[index1] > nums2[index2]) {
                m2 = m1;
                m1 = nums2[index2];
                nums2[index2] = 1000001;
                index2 = Math.min(index2 + 1, m - 1);
            } else {
                m2 = m1;
                m1 = nums1[index1];
                nums1[index1] = 1000001;
                index1 = Math.min(index1 + 1, n - 1);
            }
        }
        return (n + m) % 2 == 0 ? (double) (m1 + m2) / 2 : (double) m1;
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

