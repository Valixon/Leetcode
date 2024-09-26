import java.util.*;

public class L_2416 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})));
        System.out.println(Arrays.toString(sumPrefixScores(new String[]{"abcd"})));
        System.out.println(Arrays.toString(sumPrefixScores(new String[]{"hfjuiwcab", "hfjuiwfeqm", "hfjuif", "hfjuiwfeuv", "ammrchqrt", "qaoqjoqesy", "hfjuiwfohq"})));
    }


    public static int[] sumPrefixScores(String[] words) {
        int n = words.length;
        Map<String, Integer> map = new HashMap<>();
        List<String>[] bori = new List[n];
        for (int i = 0; i < n; i++) {
            bori[i] = new ArrayList<>();
        }
        for (int k = 0; k < n; k++) {
            String word = words[k];
            String sum = "";
            for (int i = 0; i < word.length(); i++) {
                sum += "" + word.charAt(i);
                bori[k].add(sum);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int[] res = new int[words.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bori[i].size(); j++) {
                String sum = bori[i].get(j);
                int x = map.get(sum);
                res[i] += x;
                if (x == 1) {
                    res[i] += (bori[i].size() - j - 1);
                    break;
                }
            }
        }
        return res;
    }

    public static int[] sumPrefixScores2(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        int[] qiymat = new int['z' + 1];
        List<Long>[] bori = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            bori[i] = new ArrayList<Long>();
        }
        qiymat['a'] = 11;
        qiymat['b'] = 13;
        qiymat['c'] = 17;
        qiymat['d'] = 19;
        qiymat['e'] = 23;
        qiymat['f'] = 29;
        qiymat['g'] = 31;
        qiymat['h'] = 37;
        qiymat['i'] = 41;
        qiymat['j'] = 43;
        qiymat['k'] = 47;
        qiymat['l'] = 53;
        qiymat['m'] = 59;
        qiymat['n'] = 61;
        qiymat['o'] = 67;
        qiymat['p'] = 71;
        qiymat['q'] = 73;
        qiymat['r'] = 79;
        qiymat['s'] = 83;
        qiymat['t'] = 89;
        qiymat['u'] = 97;
        qiymat['v'] = 101;
        qiymat['w'] = 103;
        qiymat['x'] = 107;
        qiymat['y'] = 109;
        qiymat['z'] = 113;
        Map<Long, Integer> map = new TreeMap<>();
        for (int k = 0; k < n; k++) {
            String word = words[k];
            long sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum = sum + (qiymat[word.charAt(i)] * ((i + 3001) * (i + 1001)));
                bori[k].add(sum);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (Long sum : bori[i]) {
                res[i] += map.get(sum);
            }
        }
        return res;
    }


    private static int[] getTuplar() {
        int[] a = new int[1001];
        int start = 115;
        for (int i = 0; i <= 1000; i++) {
            while (!tubmi(start)) {
                start++;
            }
            a[i] = start;
        }
        return a;
    }

    private static boolean tubmi(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }
}