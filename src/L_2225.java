import java.util.ArrayList;
import java.util.List;

public class L_2225 {
    public static void main(String[] args) {
//        System.out.println(closeStrings("abc", "bca"));
//        System.out.println(closeStrings("a", "aa"));
//        System.out.println(closeStrings("cabbba", "cabbba"));
//        System.out.println(closeStrings("aabbczz", "abbczzz"));

    }

    public static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> utganlar = new ArrayList<>();
        List<Integer> birMartaUttirganlar = new ArrayList<>();
        int[] utganlarSoni = new int[100001];
        int[] uttirganlarSoni = new int[100001];
        for (int[] match : matches) {
            utganlarSoni[match[0]]++;
            uttirganlarSoni[match[1]]++;
        }
        for (int i = 1; i <= 100000; i++) {
            if (utganlarSoni[i] > 0 && uttirganlarSoni[i] == 0) {
                utganlar.add(i);
            } else if (uttirganlarSoni[i] == 1) {
                birMartaUttirganlar.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(utganlar);
        res.add(birMartaUttirganlar);
        return res;
    }
}