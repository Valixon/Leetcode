import java.util.*;

public class L_332 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> salom = new ArrayList<>();
            salom.add(sc.next());
            salom.add(sc.next());
            tickets.add(salom);
        }
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new LinkedHashMap<>();
        List<String> toList = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            toList = new ArrayList<>();
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (map.containsKey(from)) {
                toList = new ArrayList<>(map.get(from));
            }
            toList.add(to);
            map.put(from, toList);
        }
        int summa = 1;
        for (String from : map.keySet()) {
            toList = new ArrayList<>(map.get(from));
            summa += toList.size();
            Collections.sort(toList);
            map.put(from, toList);
        }
        List<String> result = new ArrayList<>();
        String key = "JFK";
        result.add(key);
        result = generate(result, key, summa, map);
        return result;
    }

    public static List<String> generate(List<String> result, String key, int summa, HashMap<String, List<String>> map) {
        if (!map.containsKey(key) || map.get(key).isEmpty()) {
            return result;
        }
        List<String> toList = new ArrayList<>(map.get(key));
        for (int i = 0; i < toList.size(); i++) {
            String newKey = toList.get(i);
            result.add(toList.get(i));
            List<String> toList2 = new ArrayList<>(toList);
            toList2.remove(i);
            map.put(key, toList2);
            List<String> list = generate(result, newKey, summa, map);
            if (list.size() == summa) {
                return list;
            }
            map.put(key, toList);
            result.remove(result.size() - 1);
        }
        return result;
    }
}
/*
3
JFK KUL
JFK NRT
NRT JFK

5
JFK SFO
JFK ATL
SFO ATL
ATL JFK
ATL SFO

JFK ATL SFO ATL JFK SFO

7
JFK ATL
ORD PHL
JFK ORD
PHX LAX
LAX JFK
PHL ATL
ATL PHX


6
29 51 87 87 72 12

9
1 1 1 1 1 1 1 1 7 1

6
4 1 1 1 1 2 1

35

1 0 4 0 4 1 4 3 1 1 1 2 1 4 0 3 0 3 0 3 0 5 3 0 0 1 2 1 2 4 3 0 1 0 5 2

7
3 3 3 3 3 1 3
 */

