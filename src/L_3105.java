public class L_3105 {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{1, 4, 3, 3, 2}, 2));
    }


    public static int timeRequiredToBuy(int[] tickets, int k) {
        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += Math.min(tickets[i], tickets[k]);
        }
        for (int i = k + 1; i < tickets.length; i++) {
            sum += Math.min(tickets[i], tickets[k] - 1);
        }
        return sum;
    }
}
