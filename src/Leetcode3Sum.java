import java.util.*;

public class Leetcode3Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(threeSum(a));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int[] bormi = new int[200001];
        for (int i = 0; i < nums.length; i++) {
            bormi[100000 + nums[i]]++;
        }

        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            bormi[100000 + nums[i]]--;
            for (int j = i + 1; j < nums.length; j++) {
                bormi[100000 + nums[j]]--;
                int x = nums[i] + nums[j];
                x = -1 * x;
                if (Math.abs(x) > 100000) {
                    bormi[100000 + nums[j]]++;
                    break;
                }
                if (bormi[100000 + x] > 0) {
                    int[] temp = new int[3];
                    temp[0] = nums[i];
                    temp[1] = nums[j];
                    temp[2] = x;
                    Arrays.sort(temp);
                    result.add(List.of(temp[0], temp[1], temp[2]));
                }

                bormi[100000 + nums[j]]++;
            }
            bormi[100000 + nums[i]]++;

        }
        return result.stream().toList();
    }
}
