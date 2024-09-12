import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L_1235 {

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
        System.out.println(jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        System.out.println(jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        System.out.println(jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
    }


    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobs.sort(Comparator.comparingInt(Job::getStart));
        int index = 0;
        for (Job job : jobs) {
            startTime[index] = job.getStart();
            endTime[index] = job.getEnd();
            profit[index] = job.getProfit();
            index++;
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                hisobla(i, startTime, endTime, profit);
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }

    public static int hisobla(int index, int[] startTime, int[] endTime, int[] profit) {
        if (index >= startTime.length) return 0;
        if (dp[index] != -1) return dp[index];

        int x = Arrays.binarySearch(startTime, index, startTime.length, endTime[index]);
        if (x < 0) x = -(x + 1);
        int olinsa = profit[index] + hisobla(x, startTime, endTime, profit);
        int olinmasa = hisobla(index + 1, startTime, endTime, profit);
        return dp[index] = Math.max(olinmasa, olinsa);
    }

    public static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", profit=" + profit +
                    '}';
        }
    }
}