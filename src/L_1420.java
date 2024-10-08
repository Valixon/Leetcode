import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class L_1420 {
    public static void main(String[] args) {
//        System.out.println(numOfArrays(4, 4, 3));
//        System.out.println(numOfArrays(5, 2, 3));
//        System.out.println(numOfArrays(9, 1, 1));
//        System.out.println(numOfArrays(50, 100, 5));
//        System.out.println(numOfArrays(40, 10, 3));
//        System.out.println(numOfArrays(11, 33, 4));
//        System.out.println(numOfArrays(50, 100, 50));

        String [] a = new String[]{"15249014984681", "15249014985055", "22392716547737", "22392716592137", "22392716634937", "22392716807237", "22392716841337", "22392716897837", "22392717330237", "22392717333137", "22392717347437", "22392717474537", "22401105962837", "22401106044637", "35016227347176", "48004829297453", "48004938597674", "48004938697767", "48004938697991", "48004941497267", "48004941697093", "48009518297438", "48960474918665", "48960474918957", "48960526518758", "48960552418122", "48960552418643", "48960577618438", "48960577618892", "48961275018509", "48962736418252", "48962736418471", "48962738118082", "48968893318543", "48968971918138", "56210982215272", "56210982215747", "56210982571865", "79012914862062", "79012914864964", "79012914865830", "79012914866328", "79012914868313", "79012920454235", "79012920454820", "79012920455379", "79012920456098", "79012920456116", "79012920456141", "8002216016939"};
        String [] b = new String[]{"8002224092839", "48960552418122", "56210982571865", "22401105962837", "22392717330237", "56210982215747",
                "48009649497543", "79012914868313", "48962736418252", "48960552418643", "48962738118082", "22392716592137",
                "48960577618892", "79012928778868", "79012914866328", "15249014987161", "22392716634937", "79012914864964",
                "48009654597623", "48961275018509", "8002216016939", "28669045318850", "48960474918665", "48960474918665",
                "22392716807237", "48009515697830", "79012920455379", "56210982215272", "22392716547737", "79012928781911",
                "79012920454820", "48004829297453", "15249014984681", "28669054418211", "48960474918957", "56210982598723",
                "79012920454235", "15249014989152", "56210982572459", "48968971918138", "48960526518758", "22392717333137",
                "15249014989404", "79012920456098", "22401106044637", "48004758397661", "48004938697767", "48009518297438",
                "79012914862062", "22392716897837", "79012920456116", "48968893318543", "48004810597095", "22492997961537",
                "28669051018209", "15249014985055", "28669045318835", "48004758297682", "48004941497267", "48962736418471",
                "48960577618438", "79012920456141", "22392717347437", "35016227347176", "22392717474537", "48004938697991",
                "79012914865830", "48004703197652", "79012920458629", "22392716841337", "48009654597331", "48004938597674",
                "28669052818119", "48004941697093"};
        Set<String> a1 = Arrays.asList(a).stream().collect(Collectors.toSet());
        Set<String> b1 = Arrays.asList(b).stream().collect(Collectors.toSet());
        for (String x : a)
            b1.remove(x);
        System.out.println(b1);
    }

    public static  int[][][] memo;
    public static int MOD = (int) 1e9 + 7;
    public static int n;
    public static int m;

    public static int numOfArrays(int n1, int m2, int k) {
        n = n1;
        m = m2;
        memo = new int[n1][m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }


         int q = dp(0, 0, k);
        System.out.println(Arrays.deepToString(memo));
        return q;
    }
    public static int dp(int i, int maxSoFar, int remain) {
        if (i == n) {
            if (remain == 0) {
                return 1;
            }

            return 0;
        }

        if (remain < 0) {
            return 0;
        }

        if (memo[i][maxSoFar][remain] != -1) {
            return memo[i][maxSoFar][remain];
        }

        int ans = 0;
        for (int num = 1; num <= maxSoFar; num++) {
            ans = (ans + dp(i + 1, maxSoFar, remain)) % MOD;
        }

        for (int num = maxSoFar + 1; num <= m; num++) {
            ans = (ans + dp(i + 1, num, remain - 1)) % MOD;
        }

        memo[i][maxSoFar][remain] = ans;
        return ans;
    }
}
