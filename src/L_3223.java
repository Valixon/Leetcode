public class L_3223 {
    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
    }

    public static int minimumLength(String s) {
        int count = 0;
        int[] a = new int['z' + 1];
        for (char i : s.toCharArray())
            a[i]++;
        for (char i = 'a'; i <= 'z'; i++)
            count += (a[i] == 0 ? 0 : (a[i] % 2 == 1 ? 1 : 2));
        return count;
    }
}
