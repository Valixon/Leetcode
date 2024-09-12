import java.util.Arrays;
import java.util.LinkedList;

public class L_739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer>[] joylashuv = new LinkedList[101];
        int[] res = new int[temperatures.length];
        for (int i = 30; i <= 100; i++) {
            joylashuv[i] = new LinkedList<>();
        }
        for (int i = 0; i < temperatures.length; i++) {
            joylashuv[temperatures[i]].add(i);
        }
        for (int i = 0; i < temperatures.length; i++) {
            int x = temperatures[i];
            res[i] = 100001;
            for (int j = x + 1; j <= 100; j++) {
                while (!joylashuv[j].isEmpty() && joylashuv[j].getFirst() < i) {
                    joylashuv[j].removeFirst();
                }
                if (!joylashuv[j].isEmpty()) {
                    res[i] = Math.min(res[i], joylashuv[j].getFirst() - i);
                }
            }
            if (res[i] == 100001) res[i] = 0;
        }

        return res;
    }

}
