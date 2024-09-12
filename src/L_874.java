import java.util.TreeSet;

public class L_874 {

    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4, -1, 3}, new int[][]{}));
        System.out.println(robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
        System.out.println(robotSim(new int[]{6, -1, -1, 6}, new int[][]{}));
    }


    public static int robotSim(int[] commands, int[][] obstacles) {
        TreeSet<Integer> map = new TreeSet<>();
        for (int[] obstacle : obstacles) {
            map.add(obstacle[0] * 41301 + obstacle[1]);
        }
        int max = 0;
        int x = 0, y = 0;
        byte xx = 0;
        byte yy = 1;
        byte birminus = -1;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 1; i <= command; i++) {
                    if (map.contains((x + xx) * 41301 + (y + yy))) break;
                    x = x + xx;
                    y = y + yy;
                    max = Math.max(x * x + y * y, max);
                }
            } else if (command == -1) {
                if (xx == 0) {
                    xx = yy;
                    yy = 0;
                } else {
                    yy = (byte) (birminus * xx);
                    xx = 0;
                }
            } else {
                if (xx == 0) {
                    xx = (byte) (birminus * yy);
                    yy = 0;
                } else {
                    yy = xx;
                    xx = 0;
                }
            }
        }
        return max;
    }
}