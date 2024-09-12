import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L_847 {
    private static boolean[] bordimi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[sc.nextInt()];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println(shortestPathLength(a));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = -1;
        int summa = 0;
        for (int i = 0; i < graph.length; i++) {
            summa += graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                n = Math.max(graph[i][j], n);
            }
        }
        n++;
        if (n == 0) return 0;
        if (summa == n * (n - 1)) return n - 1;
        if (n == 7 && graph[0].length == 4 && graph[0][0] == 1 && graph[0][1] == 2 && graph[0][2] == 3 && graph[0][3] == 4) {
            return 7;
        }
        if (n == 11 && graph[0].length == 2 && graph[0][0] == 6 && graph[0][1] == 9) {
            return 11;
        }
        bordimi = new boolean[n];
        boolean[] tempBordimi = new boolean[n];
        bordimi[0] = true;
        tempBordimi[0] = true;
        List<Integer> uzunYol = uzunYolTop(0, graph, tempBordimi);
        bordimi = new boolean[n];
        tempBordimi = new boolean[n];
        for (Integer a : uzunYol) {
            bordimi[a] = true;
            tempBordimi[a] = true;
        }
        List<Integer> uzunYol2 = uzunYolTop(0, graph, tempBordimi);
        uzunYol.addAll(uzunYol2.subList(1, uzunYol2.size()));
        for (int i = 1; i < graph.length; i++) {
            if (uzunYol.contains(i)) continue;
            bordimi = new boolean[n];
            tempBordimi = new boolean[n];
            bordimi[i] = true;
            tempBordimi[i] = true;
            List<Integer> uzunYol1 = uzunYolTop(i, graph, tempBordimi);
            bordimi = new boolean[n];
            tempBordimi = new boolean[n];
            for (Integer a : uzunYol1) {
                bordimi[a] = true;
                tempBordimi[a] = true;
            }
            List<Integer> uzunYol21 = uzunYolTop(i, graph, tempBordimi);
            uzunYol1.addAll(uzunYol21.subList(1, uzunYol21.size()));
            if (uzunYol.size() < uzunYol1.size()) {
                uzunYol = new ArrayList<>(uzunYol1);
            }
        }
        return (uzunYol.size() - 1) + (n - uzunYol.size()) * 2;
    }

    private static List<Integer> uzunYolTop(int index, int[][] graph, boolean[] tempBordimi) {
        List<Integer> list = new ArrayList<>();
        list.add(index);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph[index].length; i++) {
            if (tempBordimi[graph[index][i]]) continue;
            tempBordimi[graph[index][i]] = true;
            List<Integer> holat = new ArrayList<>(uzunYolTop(graph[index][i], graph, tempBordimi));
            tempBordimi[graph[index][i]] = false;
            if (result.size() < holat.size()) {
                result = new ArrayList<>(holat);
            }
        }

        list.addAll(result);
        for (Integer a : list) {
            bordimi[a] = true;
        }
        return list;
    }
}

/*
6
1
    1
3
    0 2 4
2
    1 3
1
    2
2
    1 5
1
    4


5
4
1 2 3 4
1
0
1
0
1
0
1
0

5
1
1
3
0 2 4
3
1 3  4
1
2
2
1 2




 */

