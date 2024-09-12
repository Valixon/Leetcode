import java.util.Iterator;
import java.util.LinkedList;

public class L_815 {
    public static LinkedList<Integer> adj[];

    public static void main(String[] args) {
        int[][] routes = new int[2][3];
        routes[0] = new int[]{1, 2, 7};
        routes[1] = new int[]{3, 6, 7};
        System.out.println(numBusesToDestination(routes, 1, 6));


    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        adj = new LinkedList[routes.length];
        for (int i = 0; i < routes.length; i++) {
            adj[i] = new LinkedList<>();
            for (int j = 0; j < routes[i].length; j++) {
                adj[i].add(routes[i][j]);
            }
        }

//        return g.BFS(source, target,  1000000);
        return 0;
    }


// This code is contributed by Aakash Hasija

}