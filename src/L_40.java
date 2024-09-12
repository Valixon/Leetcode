import java.util.*;

public class L_40 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));

    }

    private static List<List<Integer>> res;
    //    private static List<List<Integer>> finish;
    private static Set<List<Integer>> finishSet = new HashSet<>();
    public static int target;
    private static int n;

    public static List<List<Integer>> combinationSum2(int[] candidates, int t) {
        res = new ArrayList<>();
        finishSet = new HashSet<>();
        target = t;
        n = candidates.length;
        Arrays.sort(candidates);
        int sum = 0;
        List<Integer> kichik = new ArrayList<>();
        nagap(sum, 0, candidates, kichik);
        return res;
    }

    private static void nagap(int sum, int index, int[] candidates, List<Integer> kichik) {
        if (index >= n) return;
        for (int i = index; i < n; i++) {
            if (sum + candidates[i] > target) return;
            kichik.add(candidates[i]);
            if (finishSet.contains(kichik)) {
//                kichik.removeLast();
                continue;
            }
            if (sum + candidates[i] == target) {
                res.add(new ArrayList<>(kichik));
            } else {
                nagap(sum + candidates[i], i + 1, candidates, kichik);
            }
            finishSet.add(new ArrayList<>(kichik));
//            kichik.removeLast();
        }
    }
}