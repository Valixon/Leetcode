public class L_2642 {
    public static void main(String[] args) {
        int n = 13;
        int[][] edges = new int[30][3];
        edges[0] = new int[]{7, 2, 131570};
        edges[1] = new int[]{9, 4, 622890};
        edges[2] = new int[]{9, 1, 812365};
        edges[3] = new int[]{1, 3, 399349};
        edges[4] = new int[]{10, 2, 407736};
        edges[5] = new int[]{10, 2, 407736};
        edges[6] = new int[]{6, 7, 880509};
        edges[7] = new int[]{1, 4, 289656};
        edges[8] = new int[]{8, 0, 802664};
        edges[9] = new int[]{6, 4, 826732};
        edges[10] = new int[]{10, 3, 567982};
        edges[11] = new int[]{5, 6, 434340};
        edges[12] = new int[]{4, 7, 833968};
        edges[13] = new int[]{12, 1, 578047};
        edges[14] = new int[]{8, 5, 739814};
        edges[15] = new int[]{10, 9, 648073};
        edges[16] = new int[]{1, 6, 679167};
        edges[17] = new int[]{3, 6, 933017};
        edges[18] = new int[]{0, 10, 399226};
        edges[19] = new int[]{1, 11, 915959};
        edges[20] = new int[]{0, 12, 393037};
        edges[21] = new int[]{11, 5, 811057};
        edges[22] = new int[]{6, 2, 100832};
        edges[23] = new int[]{5, 1, 731872};
        edges[24] = new int[]{3, 8, 741455};
        edges[25] = new int[]{2, 9, 835397};
        edges[26] = new int[]{7, 0, 516610};
        edges[27] = new int[]{11, 8, 680504};
        edges[28] = new int[]{3, 11, 455056};
        edges[29] = new int[]{1, 0, 252721};
        Graph obj = new Graph(n, edges);
        System.out.println(obj.shortestPath(9, 3));
        obj.addEdge(new int[]{11, 1, 873094});
        System.out.println(obj.shortestPath(3, 11));
        System.out.println(obj.shortestPath(3, 7));
        obj.addEdge(new int[]{0, 9, 601498});
        obj.addEdge(new int[]{12, 0, 824080});
        obj.addEdge(new int[]{12, 4, 459292});
        obj.addEdge(new int[]{6, 9, 7876});
        obj.addEdge(new int[]{11, 7, 5479});
        obj.addEdge(new int[]{11, 12, 802});
        System.out.println(obj.shortestPath(11, 7));
        System.out.println(obj.shortestPath(2, 6));
        obj.addEdge(new int[]{0, 11, 441770});
        System.out.println(obj.shortestPath(3, 7));
        obj.addEdge(new int[]{11, 0, 393443});
        System.out.println(obj.shortestPath(4, 2));
        obj.addEdge(new int[]{10, 5, 338});
        obj.addEdge(new int[]{6, 1, 305});
        obj.addEdge(new int[]{5, 0, 154});


    }

    static class Graph {
        public final long[][] a;
        public boolean hisoblandi = false;

        public Graph(int n, int[][] edges) {
            a = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < edges.length; i++) {
                a[edges[i][0]][edges[i][1]] = edges[i][2];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            hisoblabTasha();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void addEdge(int[] edge) {
            a[edge[0]][edge[1]] = Math.min(edge[2], a[edge[0]][edge[1]]);
            hisoblandi = false;
        }

        public int shortestPath(int node1, int node2) {
            if (node1 == node2) return 0;
            if (!hisoblandi) {
                hisoblabTasha();
            }
            return a[node1][node2] == Integer.MAX_VALUE ? -1 : (int) a[node1][node2];
        }

        public void hisoblabTasha() {
            int n = a.length;
            boolean uzgardi = true;
            while (uzgardi) {
                uzgardi = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        for (int k = 0; k < n; k++) {
                            if (a[i][j] > a[i][k] + a[k][j]) {
                                a[i][j] = a[i][k] + a[k][j];
                                uzgardi = true;
                            }
                        }
                    }
                }
            }
            hisoblandi = true;
        }

    }
}