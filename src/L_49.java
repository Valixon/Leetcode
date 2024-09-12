import java.util.*;

public class L_49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            String tartiblangan = getTartibli(str);
            List<String> x = res.getOrDefault(tartiblangan, new ArrayList<>());
            x.add(str);
            res.put(tartiblangan, x);
        }
        return new ArrayList<>(res.values());
    }

    private static String getTartibli(String str) {
        byte[] bytes = new byte[str.length()];
        str.getBytes(0, str.length(), bytes, 0);
        Arrays.sort(bytes);
        StringBuilder res = new StringBuilder();
        for (byte i : bytes) {
            res.append(i);
        }
        return res.toString();
    }
}
