public class L_1458 {
    public static void main(String[] args) {
        System.out.println(maxDotProduct(new int[]{7, 2, 2, -1, -1, 1, -4, 7, 6}, new int[]{-7, -9, -1, 2, 2, 5, -7, 2, -7, 5}));
//        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
//        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
//        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));

    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            max = Math.max(max, hisobla(i, nums1, 0, nums2, 0));
        }
        for (int i = 0; i < nums2.length; i++) {
            max = Math.max(max, hisobla(i, nums2, 0, nums1, 0));
        }
        return max;
    }

    public static int hisobla(int index1, int[] nums1, int index2, int[] nums2, int sum) {
        System.out.println(nums1[index1] + " " + nums2[index2] + " " + sum);
        int max = Math.max(sum == 0 ? Integer.MIN_VALUE : 0, nums1[index1] * nums2[index2]);
        if (index1 == nums1.length - 1) {
            for (int i = index2; i < nums2.length; i++) {
                max = Math.max(nums1[index1] * nums2[i], max);
            }
            System.out.println(nums1[index1] + " " + nums2[index2] + " " + max + " " + sum);
            return sum + max;
        }
        if (index2 == nums2.length - 1) {
            for (int i = index1; i < nums1.length; i++) {
                max = Math.max(nums2[index2] * nums1[i], max);
            }
            System.out.println(nums1[index1] + " " + nums2[index2] + " " + max + " " + sum);
            return sum + max;
        }
        if (sum != 0) {
            if (nums1[index1] * nums2[index2] > 0) {
                sum += (nums1[index1] * nums2[index2]);
            }
        } else {
            sum += (nums1[index1] * nums2[index2]);
        }
        for (int i = index2 + 1; i < nums2.length; i++) {
            max = Math.max(max, hisobla(i, nums2, index1 + 1, nums1, sum));
        }
        System.out.println(nums1[index1] + " " + nums2[index2] + " " + max + " " + sum);
        return Math.max(sum, max);
    }
}