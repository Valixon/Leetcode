import java.util.Arrays;
import java.util.List;

public class L_539 {
    public static void main(String[] args) {
        System.out.println(findMinDifference(List.of(new String[]{"23:59", "00:00"})));
        System.out.println(findMinDifference(List.of(new String[]{"00:00", "23:59", "00:00"})));
    }

    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) return 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = convertTimeToInt(timePoints.get(i));
        }
        Arrays.sort(a);
        int min = 1440 - a[n - 1] + a[0];
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(a[i + 1] - a[i], min);
        }
        return min;
    }

    private static int convertTimeToInt(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60
                + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}