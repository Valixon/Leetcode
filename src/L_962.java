import java.util.TreeMap;

public class L_962 {
    public static void main(String[] args) {
//        System.out.println(smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1));
        System.out.println(smallestChair(new int[][]{{1, 2}, {2, 3}, {3, 4}}, 2));
    }


    public static int smallestChair(int[][] times, int targetFriend) {
        TreeMap<Integer, Integer> a = new TreeMap<>();
        int[] b = new int[100001];
        for (int[] time : times) {
            a.put(time[0], time[1]);
        }
        int index = 0;
        int res = -1;
        for (Integer i : a.keySet()) {
            res = -1;
            for (int j = 0; j < index; j++) {
                if (b[j] <= i) {
                    b[j] = a.get(i);
                    res = j;
                    break;
                }
            }
            if (res == -1) {
                b[index] = a.get(i);
                res = index;
                index++;
            }
            if (i == times[targetFriend][0]) break;
        }
        return res;
    }
}
