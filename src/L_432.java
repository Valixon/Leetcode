import java.util.HashMap;
import java.util.Map;

public class L_432 {
    public static void main(String[] args) {
    }


    static class AllOne {
        Map<String, Integer> map;
        int max = 0;
        String maxKey = "";
        int min = 1000000;
        String minKey = "";


        public AllOne() {
            map = new HashMap<>();
        }

        public void inc(String key) {
            int val = map.getOrDefault(key, 0);
            val++;
            map.put(key, val);
            if (val > max) {
                max = val;
                maxKey = key;
            }
            if (key.equals(minKey)) {
                min = 1000000;
                minKey="";
                for (String k : map.keySet()) {
                    int p = map.get(k);
                    if (min > p) {
                        min = p;
                        minKey = k;
                    }
                }
            }
            if (minKey.isEmpty() || min > val){
                minKey=key;
                min=val;
            }
            System.out.println(key+" "+max+" "+ val);
        }

        public void dec(String key) {
            int val = map.getOrDefault(key, 0);
            val--;
            if (val == 0) {
                map.remove(key);
                if (key.equals(minKey)){
                    min = 1000000;
                    for (String k : map.keySet()) {
                        int p = map.get(k);
                        if (min > p) {
                            min = p;
                            minKey = k;
                        }
                    }
                }
            } else {
                if (val < min) {
                    min = val;
                    minKey = key;
                }
                map.put(key, val);
            }
            if (key.equals(maxKey)) {
                max = 0;
                for (String k : map.keySet()) {
                    int p = map.get(k);
                    if (max < p) {
                        max = p;
                        maxKey = k;
                    }
                }
            }
        }

        public String getMaxKey() {
            System.out.println(map);
            return maxKey;
        }

        public String getMinKey() {
            return minKey;
        }
    }
}
