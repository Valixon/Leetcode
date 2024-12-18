import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_2463 {
    public static void main(String[] args) {
        System.out.println(minimumTotalDistance(new ArrayList<>(List.of(789300819, -600989788, 529140594, -592135328, -840831288, 209726656, -671200998)), new int[][]{{-865262624, 6}, {-717666169, 0}, {725929046, 2}, {449443632, 3}, {-912630111, 0}, {270903707, 3}, {-769206598, 2}, {-299780916, 4}, {-159433745, 5}, {-467185764, 3}, {849991650, 7}, {-292158515, 6}, {940410553, 6}, {258278787, 0}, {83034539, 2}, {54441577, 3}, {-235385712, 2}, {75791769, 3}}));
        System.out.println(minimumTotalDistance(new ArrayList<>(List.of(0, 4, 6)), new int[][]{{2, 2}, {6, 2}}));
        System.out.println(minimumTotalDistance(new ArrayList<>(List.of(1, -1)), new int[][]{{-2, 1}, {2, 1}}));
        System.out.println(minimumTotalDistance(new ArrayList<>(List.of(9, 11, 99, 101)), new int[][]{{7, 1}, {10, 1}, {14, 1}, {100, 1}, {96, 1}, {103, 1}}));
    }

    public static Map<String, Long> mp = new HashMap<>();

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        if (mp.containsKey(getString(robot.size(), factory))) {
            return mp.get(getString(robot.size(), factory));
        }
        if (robot.isEmpty()) return 0;
        long sum = Long.MAX_VALUE;
        int o = robot.get(0);
        for (int j = 0; j < factory.length; j++) {
            if (factory[j][1] > 0) {
                int p = Math.abs(factory[j][0] - o);
                if (sum < p) {
                    continue;
                }
                factory[j][1]--;
                long m = p + minimumTotalDistance(robot.subList(1, robot.size()), factory);
                factory[j][1]++;
                if (sum > m) {
                    sum = m;
                }
            }
        }
        mp.put(getString(robot.size(), factory), sum);
        return sum;
    }

    private static String getString(int size, int[][] factory) {
        String s = "";
        for (int i = 0; i < factory.length; i++) {
            if (factory[i][1]>0) {
                s = s + "" + factory[i][0] + ":" + factory[i][1] + ";";
            }
        }
        return s;
    }
}