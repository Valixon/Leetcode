import java.util.TreeSet;

public class L_1838 {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, 15));
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));
    }

    public static int maxFrequency(int[] nums, int k) {
        int[] count = new int[100001];
        TreeSet<Integer> a = new TreeSet<>();
        for (int num : nums) {
            count[num]++;
            a.add(num);
        }
        int n = a.size();
        int[] arr = new int[n];
        int index = n - 1;
        for (Integer i : a) {
            arr[index--] = i;
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int res = count[arr[i]];
            for (int j = i + 1; j < n; j++) {
                int sum2 = count[arr[j]] * (arr[i] - arr[j]);
                if (sum + sum2 <= k) {
                    sum += sum2;
                    res += count[arr[j]];
                } else {
                    int qoldi = k - sum;
                    int amalla = qoldi / (arr[i] - arr[j]);
                    res += amalla;
                    break;
                }
            }
            max = Math.max(res, max);
        }
        return max;
    }
}