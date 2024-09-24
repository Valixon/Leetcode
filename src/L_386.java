import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_386 {
    public static void main(String[] args) {
    }

    public List<Integer> lexicalOrder(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = "" + (i + 1);
        }
        Arrays.sort(a);
        List<Integer> res = new ArrayList<>();
        for (String i : a)
            res.add(Integer.parseInt(i));
        return res;
    }
}