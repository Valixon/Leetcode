public class L_992 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }


    public static int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] soni = new int[n + 1];
        int l = 0;
        int count = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            soni[nums[r]]++;
            if (soni[nums[r]] == 1) {
                count++;
            }
            if (count == k) {
                sum += hisobla(r, l, k, nums, soni.clone());
                continue;
            }
            while (count > k) {
                soni[nums[l]]--;
                if (soni[nums[l]] == 0) {
                    count--;
                }
                l++;
            }
            if (count == k) {
                sum += hisobla(r, l, k, nums, soni.clone());
            }
        }
        return sum;
    }

    private static int hisobla(int r, int l, int k, int[] nums, int[] soni) {
        int count = k;
        int sum = 0;
        while (count == k) {
            sum++;
            soni[nums[l]]--;
            if (soni[nums[l]] == 0) {
                count--;
            }
            l++;
        }
        return sum;
    }
}
