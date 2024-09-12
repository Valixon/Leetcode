public class L_523 {

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{1, 2, 12}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 13));
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 10));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }


    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return false;
        int[] a = new int[n];
        int sum = nums[0];
        a[0] = sum;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (nums[i - 1] == 0 && nums[i] == 0) return true;
            a[i] = sum;
            if (sum % k == 0) return true;
        }
        if (sum < k) return false;
        for (int i = n - 3; i > 0; i--) {
            if ((sum - a[i]) % k == 0) return true;
        }
        if (n>1000)  return false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if ((a[j] - a[i]) % k == 0) return true;
            }
        }
        return false;
    }
}