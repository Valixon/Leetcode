import java.util.ArrayList;
import java.util.List;

public class L_802 {

    public static void main(String[] args) {
//        System.out.println(eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
//        System.out.println(eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}));
        System.out.println(eventualSafeNodes(new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}}));
        System.out.println(eventualSafeNodes(new int[][]{{4, 9}, {3, 5, 7}, {0, 3, 4, 5, 6, 8}, {7, 8, 9}, {5, 6, 7, 8}, {6, 7, 8, 9}, {7, 9}, {8, 9}, {9}, {}}));
    }


    private static Integer[] bordikmi;
    private static ArrayList<Integer> result;

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        bordikmi = new Integer[n];
        for (int i = 0; i < n; i++) {
            if (bordikmi[i] == null) {
                hisobla(i, graph);
            }
        }
        for (int i = 0; i < n; i++) {
            if (bordikmi[i] <= 1) {
                result.add(i);
            }
        }
        return result;
    }

    private static int hisobla(int index, int[][] graph) {
        bordikmi[index] = 5;
        if (graph[index].length == 0) {
            bordikmi[index] = 0;
            return 0;
        }
        int max = 0;
        for (int i : graph[index]) {
            if (bordikmi[i] == null) {
                bordikmi[i] = hisobla(i, graph);
                if (bordikmi[i] > 0) {
                    bordikmi[index] = 2;
                    return max;
                }
            }
            max = Math.max(max, bordikmi[i]);
        }
        bordikmi[index] = max + 1;
        return max;
    }
}
