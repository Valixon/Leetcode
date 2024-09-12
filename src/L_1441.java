import java.util.ArrayList;
import java.util.List;

public class L_1441 {

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{1, 3}, 3));
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (i == target[index]) {
                index++;
                res.add("Push");
                if (index == target.length) {
                    return res;
                }
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

}
