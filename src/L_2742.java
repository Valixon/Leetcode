import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L_2742 {
    public static void main(String[] args) {
//        System.out.println(paintWalls(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2}));
//        System.out.println(paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
//        System.out.println(paintWalls(new int[]{49, 35, 32, 20, 30, 12, 42}, new int[]{1, 1, 2, 2, 1, 1, 2}));
        System.out.println(paintWalls(new int[]{42,8,28,35,21,13,21,35}, new int[]{2,1,1,1,2,1,1,2}));
    }

    public static int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        List<Salom> saloms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            saloms.add(new Salom(cost[i], time[i], ((double) cost[i] / time[i])));
        }
        Collections.sort(saloms, new Comparator() {

            public int compare(Object o1, Object o2) {

                double x1 = ((Salom) o1).getNisbat();
                double x2 = ((Salom) o2).getNisbat();
                int sComp = Double.compare(x1, x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer x3 = ((Salom) o1).getTime();
                Integer x4 = ((Salom) o2).getTime();
                sComp = Integer.compare(x3, x4) * -1;
                if (sComp != 0) {
                    return sComp;
                }
                Integer x5 = ((Salom) o1).getCost();
                Integer x6 = ((Salom) o2).getCost();
                sComp = Integer.compare(x5, x6);
                return sComp;
            }
        });
        int times = 0;
        int soqqa = 0;
        int qoldi = 1;
        System.out.println(saloms);
        for (Salom salom : saloms) {
            if (times + salom.getTime() < n - qoldi) {
                qoldi++;
                times += salom.getTime();
                soqqa += salom.getCost();
                salom.setTime(-1);
            } else {
                int finalQoldi = qoldi;
                int finalTimes = times;
                List<Salom> saloms1 = saloms.stream().filter(o -> (finalTimes + o.getTime() == (n - finalQoldi))).sorted(Comparator.comparingInt(Salom::getCost)).toList();
                if (saloms1.isEmpty()) {
                    soqqa += salom.getCost();
                    break;
                } else {
                    salom = saloms1.get(0);
                    soqqa += salom.getCost();
                    break;
                }
            }
        }
        return soqqa;
    }

    public static class Salom {
        int cost;
        int time;
        double nisbat;

        public Salom(int cost, int time, double nisbat) {
            this.cost = cost;
            this.time = time;
            this.nisbat = nisbat;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public double getNisbat() {
            return nisbat;
        }

        public void setNisbat(double nisbat) {
            this.nisbat = nisbat;
        }

        @Override
        public String toString() {
            return "Salom{" +
                    "cost=" + cost +
                    ", time=" + time +
                    ", nisbat=" + nisbat +
                    '}';
        }
    }
}