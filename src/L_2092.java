import java.util.*;
import java.util.stream.Collectors;

public class L_2092 {

    public static void main(String[] args) {
        System.out.println(findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));
        System.out.println(findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3));
    }

    static class Jumanazar {
        int birinchi;
        int ikkinchi;
        int time;

        public Jumanazar(int birinchi, int ikkinchi, int time) {
            this.birinchi = birinchi;
            this.ikkinchi = ikkinchi;
            this.time = time;
        }

        public int getBirinchi() {
            return birinchi;
        }

        public void setBirinchi(int birinchi) {
            this.birinchi = birinchi;
        }

        public int getIkkinchi() {
            return ikkinchi;
        }

        public void setIkkinchi(int ikkinchi) {
            this.ikkinchi = ikkinchi;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Jumanazar{" +
                    "birinchi=" + birinchi +
                    ", ikkinchi=" + ikkinchi +
                    ", time=" + time +
                    '}';
        }
    }


    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Jumanazar> jumanazars = new ArrayList<>();
        for (int[] meeting : meetings) {
            jumanazars.add(new Jumanazar(meeting[0], meeting[1], meeting[2]));
        }
        jumanazars.add(new Jumanazar(0, firstPerson, 0));
        Map<Integer, List<Jumanazar>> integerListMap =
                jumanazars.stream().collect(Collectors.groupingBy(w -> w.time));
        boolean[] bilami = new boolean[n];
        bilami[0] = true;
        bilami[firstPerson] = true;
        SortedSet<Integer> keys = new TreeSet<>(integerListMap.keySet());
        for (Integer time : keys) {
            List<Jumanazar> x = integerListMap.get(time);
            boolean bormi = true;
            while (bormi) {
                bormi = false;
                for (Jumanazar jumanazar : x) {
                    if (bilami[jumanazar.birinchi] || bilami[jumanazar.ikkinchi]) {
                        bilami[jumanazar.birinchi] = bilami[jumanazar.ikkinchi] = true;
                        x.remove(jumanazar);
                        bormi = true;
                        break;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (bilami[i]) res.add(i);
        }
        return res;
    }
}
