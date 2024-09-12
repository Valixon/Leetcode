import java.util.Arrays;

public class L_2699 {

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(modifiedGraphEdges(5, new int[][]{{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}}, 0, 1, 5)));
//        System.out.println(Arrays.deepToString(modifiedGraphEdges(3, new int[][]{{0, 1, -1}, {0, 2, 5}}, 0, 2, 6)));
//        System.out.println(Arrays.deepToString(modifiedGraphEdges(4, new int[][]{{0, 2, -1}, {1, 2, -1}, {3, 2, 8}, {1, 3, 8}, {3, 0, 6}, {0, 1, 6}}, 1, 0, 4)));
//        System.out.println(Arrays.deepToString(modifiedGraphEdges(5, new int[][]{{0, 2, 5}, {2, 1, -1}, {2, 4, 3}, {3, 4, 5}, {4, 0, 1}, {0, 3, -1}, {2, 3, -1}}, 0, 1, 9)));
        System.out.println(Arrays.deepToString(modifiedGraphEdges(4, new int[][]{{0, 1, -1}, {2, 0, 2}, {3, 2, 6}, {2, 1, 10}, {3, 0, -1}}, 1, 3, 12)));
    }


        private static int count;
        private static int lastI;
        private static int lastJ;
        private static int targetStat;
        private static int sourceStat;

        public static int[][] modifiedGraphEdges ( int n, int[][] edges, int source, int destination, int target){
            int[][] dp = new int[n][n];
            count = 0;
            targetStat = target;
            sourceStat = source;
            boolean yurdimi[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = -1;
                }
            }
            for (int[] edge : edges) {
                if (edge[2] == -1) {
                    dp[edge[0]][edge[1]] = 0;
                    dp[edge[1]][edge[0]] = 0;
                } else {
                    dp[edge[0]][edge[1]] = edge[2];
                    dp[edge[1]][edge[0]] = edge[2];
                }
            }
            int res = kurqani(dp, yurdimi, source, destination, target);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            if (res == 1) {
                for (int[] edge : edges) {
                    if (edge[2] == -1) {
                        if (dp[edge[0]][edge[1]] == 0) {
                            edge[2] = 10000000;
                            dp[edge[0]][edge[1]] = 10000000;
                        } else {
                            edge[2] = dp[edge[0]][edge[1]];
                        }
                    }
                }
                yurdimi = new boolean[n];
                int minTarget = bfs(dp, yurdimi, source, destination, 0);
                System.out.println(source + " " + destination + " " + minTarget);

                if (minTarget == target) {
                    return edges;
                }
            } else {
                yurdimi = new boolean[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[i][j] = -1;
                    }
                }
                for (int[] edge : edges) {
                    if (edge[2] == -1) {
                        dp[edge[0]][edge[1]] = 0;
                        dp[edge[1]][edge[0]] = 0;
                    } else {
                        dp[edge[0]][edge[1]] = edge[2];
                        dp[edge[1]][edge[0]] = edge[2];
                    }
                }
                res = kurqani(dp, yurdimi, destination, sourceStat, targetStat);
                if (res == 1) {
                    for (int[] edge : edges) {
                        if (edge[2] == -1) {
                            if (dp[edge[0]][edge[1]] == 0) {
                                edge[2] = 10000000;
                                dp[edge[0]][edge[1]] = 10000000;
                            } else {
                                edge[2] = dp[edge[0]][edge[1]];
                            }
                        }
                    }
                    yurdimi = new boolean[n];
                    int minTarget = bfs(dp, yurdimi, source, destination, 0);
                    System.out.println(source + " " + destination + " " + minTarget);

                    if (minTarget == target) {
                        return edges;
                    }
                }
            }
            return new int[0][0];
        }

        private static int bfs ( int[][] dp, boolean[] yurdimi, int source, int destination, int target){
            int n = yurdimi.length;
            if (source == destination) {
                return target;
            }
            int min = 1000000;
            yurdimi[source] = true;
            for (int i = 0; i < n; i++) {
                if (!yurdimi[i] && dp[source][i] > 0) {
                    min = Math.min(min, bfs(dp, yurdimi, i, destination, target + dp[source][i]));
                }
            }
            yurdimi[source] = false;
            return min;
        }

        private static int kurqani ( int[][] dp, boolean[] yurdimi, int source, int destination, int target){
            int n = yurdimi.length;
            for (int j = 0; j < n; j++) {
                if (!yurdimi[j] && dp[source][j] > -1) {
                    if (j == destination) {
                        if (dp[source][destination] == target) {
                            return 1;
                        } else if (dp[source][destination] == 0) {
                            count++;
                            dp[source][destination] = target;
                            dp[destination][source] = target;
                            boolean t[] = new boolean[n];
                            int minTarget = bfs(dp, t, sourceStat, destination, 0);
                            if (minTarget == targetStat) {
                                return 1;
                            } else {
                                dp[source][destination] = 0;
                                dp[destination][source] = 0;
                                continue;
                            }
                        } else if (dp[source][destination] < target && count > 0) {
                            dp[lastI][lastJ] = (target - dp[source][destination]) + 1;
                            dp[lastJ][lastI] = (target - dp[source][destination]) + 1;
                            return 1;
                        }
                        continue;
                    }
                    if (target - dp[source][j] <= 0) continue;
                    yurdimi[source] = true;
                    if (dp[source][j] == 0) {
                        lastI = source;
                        lastJ = j;
                        dp[source][j] = 1;
                        dp[j][source] = 1;
                    }
                    int res = kurqani(dp, yurdimi, j, destination, target - dp[source][j]);
                    if (res == 1) return 1;
                    if (lastI == source && lastJ == j) {
                        dp[source][j] = 0;
                        dp[j][source] = 0;
                    }
                    yurdimi[source] = false;
                }
            }
            return 0;
        }
    }