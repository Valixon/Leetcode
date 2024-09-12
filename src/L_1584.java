import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class L_1584 {
    public  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        System.out.println(minCostConnectPoints(a));
    }

    // Defines edge structure
    class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Defines subset element structure
    class Subset {
        int parent, rank;

        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        List<Edge> graphEdges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                graphEdges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }


        // Sort the edges in non-decreasing order
        // (increasing with repetition allowed)
        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        return kruskals(V, graphEdges);
    }

    // Function to find the MST
    public  int kruskals(int V, List<Edge> edges) {
        int j = 0;
        int noOfEdges = 0;

        // Allocate memory for creating V subsets
        Subset subsets[] = new Subset[V];

        // Allocate memory for results
        Edge results[] = new Edge[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // Number of edges to be taken is equal to V-1
        while (noOfEdges < V - 1) {

            // Pick the smallest edge. And increment
            // the index for next iteration
            Edge nextEdge = edges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            // If including this edge doesn't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;
        }

        // Print the contents of result[] to display the
        // built MST
        System.out.println(
                "Following are the edges of the constructed MST:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- "
                    + results[i].dest + " == "
                    + results[i].weight);
            minCost += results[i].weight;
        }
        System.out.println("Total cost of MST: " + minCost);
        return minCost;
    }

    // Function to unite two disjoint sets
    public void union(Subset[] subsets, int x,
                              int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank
                < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Function to find parent of a set
    public  int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent
                = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
}
/*
5
0 0
2 2
3 10
5 2
7 0

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

