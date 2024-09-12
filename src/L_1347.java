public class L_1347 {
    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println(minSteps("bab", "aba"));
        System.out.println(minSteps("leetcodez", "practice"));

    }

    public static int minSteps(String s, String t) {
        int[] a = new int[26];
        byte[] sb = s.getBytes(), tb = t.getBytes();
        for (byte i : sb) {
            a[i - 'a']++;
        }
        for (byte i : tb) {
            a[i - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i <= 25; i++) {
            if (a[i] > 0) {
                sum += a[i];
            }
        }
        return sum;
    }
}