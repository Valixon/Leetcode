public class L_165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));
    }

    public static int compareVersion(String version1, String version2) {
        version1 = version1 + ".0";
        version2 = version2 + ".0";
        int x = Integer.parseInt(version1.substring(0, version1.indexOf(".")));
        int y = Integer.parseInt(version2.substring(0, version2.indexOf(".")));
        if (x > y) {
            return 1;
        } else if (x < y) {
            return -1;
        } else {
            version1 = version1.substring(version1.indexOf(".")).replaceAll("\\D+", "");
            version2 = version2.substring(version2.indexOf(".")).replaceAll("\\D+", "");
            if (version1.length() > version2.length()) {
                int farq = version1.length() - version2.length();
                for (int i = 1; i <= farq; i++) {
                    version2 += "0";
                }
            } else {
                int farq = version2.length() - version1.length();
                for (int i = 1; i <= farq; i++) {
                    version1 += "0";
                }
            }
            version1 = Integer.parseInt(version1) + "";
            version2 = Integer.parseInt(version2) + "";
            System.out.println(version1);
            System.out.println(version2);
            if (version1.compareTo(version2) > 0) {
                return 1;
            } else if (version1.compareTo(version2) < 0) {
                return -1;
            }
            return 0;
        }
    }
}
