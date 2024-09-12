import java.util.Arrays;

public class L_881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{1, 2, 3, 4, 5}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int cnt = 0;
        for (int i = people.length - 1; i >= left; i--) {
            if (people[i] + people[left] <= limit) {
                left++;
            }
            cnt++;
        }
        return cnt;
    }
}
