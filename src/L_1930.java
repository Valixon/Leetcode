import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_1930 {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));


    }

    public static int countPalindromicSubsequence(String s) {
        int sum = 0;
        List<Integer>[] joy = new List['z' + 1];
        Set<Character> a = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char r = s.charAt(i);
            if (joy[r] == null) {
                joy[r] = new ArrayList<>();
            }
            joy[r].add(i);
            a.add(r);
        }

        for (char i : a) {
            int size = joy[i].size();
            if (size == 1) continue;
            int boshi = joy[i].get(0);
            int oxiri = joy[i].get(size - 1);
            for (char ch : a) {
                for (Integer e : joy[ch]) {
                    if (e >= oxiri) break;
                    if (e > boshi) {
                        sum++;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}