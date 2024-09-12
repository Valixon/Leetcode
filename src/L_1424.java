import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_1424 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> ichi = new ArrayList<>();
        ichi.add(1);
        ichi.add(2);
        ichi.add(3);
        ichi.add(4);
        ichi.add(5);
        nums.add(ichi);
        List<Integer> ichi2 = new ArrayList<>();
        ichi2.add(6);
        ichi2.add(7);
        nums.add(ichi2);
        List<Integer> ichi3 = new ArrayList<>();
        ichi3.add(8);
        nums.add(ichi3);
        List<Integer> ichi4 = new ArrayList<>();
        ichi4.add(9);
        ichi4.add(10);
        ichi4.add(11);
        nums.add(ichi4);
        List<Integer> ichi5 = new ArrayList<>();
        ichi5.add(12);
        ichi5.add(13);
        ichi5.add(14);
        ichi5.add(14);
        ichi5.add(16);
        nums.add(ichi5);
        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int[] res = new int[100000];
        int index = 0;
        int ip = 0;
        while (!nums.isEmpty() && ip != nums.size()) {
            for (int i = ip; i >= 0; i--) {
                List<Integer> list = nums.get(i);
                res[index++] = list.get(0);
                list.remove(0);
                if (list.isEmpty()) {
                    nums.remove(i);
                    ip--;
                }
            }
            ip++;
        }
        System.out.println(nums);
        while (!nums.isEmpty()) {
            ip = nums.size() - 1;
            for (int i = ip; i >= 0; i--) {
                List<Integer> list = nums.get(i);
                res[index++] = list.get(0);
                list.remove(0);
                if (list.isEmpty()) {
                    nums.remove(i);
                } else {
                    ip--;
                }
            }
        }
        System.out.println(nums);
        int[] a = new int[index];
        for (int i = 0; i < index; i++) {
            a[i] = res[i];
        }
        return a;
    }
}