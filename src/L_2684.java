public class L_2684 {
    public static void main(String[] args) {
        System.out.println(maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
        System.out.println(maxMoves(new int[][]{{1000000, 92910, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068},{
        1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118}}))
        ;
    }

    public static int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = grid[i - 1][j - 1];
            }
        }
        for (int i = 0; i <= m + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            dp[n + 1][i] = Integer.MAX_VALUE;
        }
        boolean bormi = false;
        for (int j = 1; j <= m; j++) {
            bormi = false;
            for (int i = 1; i <= n; i++) {
                if (dp[i][j] > dp[i - 1][j - 1] || dp[i][j] > dp[i - 1][j] || dp[i][j] > dp[i - 1][j + 1]) {
                    bormi = true;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            if (!bormi) return j - 1;
        }
        return n - 1;
    }

}