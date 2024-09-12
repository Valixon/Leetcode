public class L_1701 {
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{{1, 2}, {2, 5}, {4, 3}}));
        System.out.println(averageWaitingTime(new int[][]{{5, 2}, {5, 4}, {10, 3}, {20, 1}}));
    }

    public static double averageWaitingTime(int[][] customers) {
        long current = customers[0][0];
        double kutgaplar = 0;
        for (int[] customer : customers) {
            int x = customer[0];
            int y = customer[1];
            if (current > x) {
                kutgaplar += (current - x + y);
                current += y;
            } else {
                current = x + y;
                kutgaplar += y;
            }
        }
        return kutgaplar / customers.length;
    }
}