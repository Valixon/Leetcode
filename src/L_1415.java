public class L_1415 {

    public static void main(String[] args) {
        System.out.println(getHappyString(1, 3));
        System.out.println(getHappyString(2, 3));
        System.out.println(getHappyString(3, 3));
        System.out.println(getHappyString(4, 3));
        System.out.println(getHappyString(5, 3));
        System.out.println(getHappyString(6, 3));
        System.out.println(getHappyString(7, 3));
        System.out.println(getHappyString(8, 3));
        System.out.println(getHappyString(9, 3));
        System.out.println(getHappyString(10, 3));
    }


    public static final String [][] a = new String[][]{
            {"a","b","c"},
            {"ab","ac","ba","bc","ca","cb"},
            {"aba","abc","aca","acb","bab","bac","bca","bcb","cab","cac","cba","cbc"},
            {"abab","abac","abca","abcb","acab","acac","acba","acbc","baba","babc","baca","bacb","bcab","bcac","bcba","bcbc","caba","cabc","caca","cacb","cbab","cbac","cbca","cbcb"},
            {"ababa","ababc","abaca","abacb","abcab","abcac","abcba","abcbc","acaba","acabc","acaca","acacb","acbab","acbac","acbca","acbcb","babab","babac","babca","babcb","bacab","bacac","bacba","bacbc","bcaba","bcabc","bcaca","bcacb","bcbab","bcbac","bcbca","bcbcb","cabab","cabac","cabca","cabcb","cacab","cacac","cacba","cacbc","cbaba","cbabc","cbaca","cbacb","cbcab","cbcac","cbcba","cbcbc"},
            {"ababab","ababac","ababca","ababcb","abacab","abacac","abacba","abacbc","abcaba","abcabc","abcaca","abcacb","abcbab","abcbac","abcbca","abcbcb","acabab","acabac","acabca","acabcb","acacab","acacac","acacba","acacbc","acbaba","acbabc","acbaca","acbacb","acbcab","acbcac","acbcba","acbcbc","bababa","bababc","babaca","babacb","babcab","babcac","babcba","babcbc","bacaba","bacabc","bacaca","bacacb","bacbab","bacbac","bacbca","bacbcb","bcabab","bcabac","bcabca","bcabcb","bcacab","bcacac","bcacba","bcacbc","bcbaba","bcbabc","bcbaca","bcbacb","bcbcab","bcbcac","bcbcba","bcbcbc","cababa","cababc","cabaca","cabacb","cabcab","cabcac","cabcba","cabcbc","cacaba","cacabc","cacaca","cacacb","cacbab","cacbac","cacbca","cacbcb","cbabab","cbabac","cbabca","cbabcb","cbacab","cbacac","cbacba","cbacbc","cbcaba","cbcabc","cbcaca","cbcacb","cbcbab","cbcbac","cbcbca","cbcbcb"},
            {"abababa","abababc","ababaca","ababacb","ababcab","ababcac","ababcba","ababcbc","abacaba","abacabc","abacaca","abacacb","abacbab","abacbac","abacbca","abacbcb","abcabab","abcabac","abcabca","abcabcb","abcacab","abcacac","abcacba","abcacbc","abcbaba","abcbabc","abcbaca","abcbacb","abcbcab","abcbcac","abcbcba","abcbcbc","acababa","acababc","acabaca","acabacb","acabcab","acabcac","acabcba","acabcbc","acacaba","acacabc","acacaca","acacacb","acacbab","acacbac","acacbca","acacbcb","acbabab","acbabac","acbabca","acbabcb","acbacab","acbacac","acbacba","acbacbc","acbcaba","acbcabc","acbcaca","acbcacb","acbcbab","acbcbac","acbcbca","acbcbcb","bababab","bababac","bababca","bababcb","babacab","babacac","babacba","babacbc","babcaba","babcabc","babcaca","babcacb","babcbab","babcbac","babcbca","babcbcb","bacabab","bacabac","bacabca","bacabcb","bacacab","bacacac","bacacba","bacacbc","bacbaba","bacbabc","bacbaca","bacbacb","bacbcab","bacbcac","bacbcba","bacbcbc","bcababa","bcababc","bcabaca","bcabacb"},
            {"abababab","abababac","abababca","abababcb","ababacab","ababacac","ababacba","ababacbc","ababcaba","ababcabc","ababcaca","ababcacb","ababcbab","ababcbac","ababcbca","ababcbcb","abacabab","abacabac","abacabca","abacabcb","abacacab","abacacac","abacacba","abacacbc","abacbaba","abacbabc","abacbaca","abacbacb","abacbcab","abacbcac","abacbcba","abacbcbc","abcababa","abcababc","abcabaca","abcabacb","abcabcab","abcabcac","abcabcba","abcabcbc","abcacaba","abcacabc","abcacaca","abcacacb","abcacbab","abcacbac","abcacbca","abcacbcb","abcbabab","abcbabac","abcbabca","abcbabcb","abcbacab","abcbacac","abcbacba","abcbacbc","abcbcaba","abcbcabc","abcbcaca","abcbcacb","abcbcbab","abcbcbac","abcbcbca","abcbcbcb","acababab","acababac","acababca","acababcb","acabacab","acabacac","acabacba","acabacbc","acabcaba","acabcabc","acabcaca","acabcacb","acabcbab","acabcbac","acabcbca","acabcbcb","acacabab","acacabac","acacabca","acacabcb","acacacab","acacacac","acacacba","acacacbc","acacbaba","acacbabc","acacbaca","acacbacb","acacbcab","acacbcac","acacbcba","acacbcbc","acbababa","acbababc","acbabaca","acbabacb"},
            {"ababababa","ababababc","abababaca","abababacb","abababcab","abababcac","abababcba","abababcbc","ababacaba","ababacabc","ababacaca","ababacacb","ababacbab","ababacbac","ababacbca","ababacbcb","ababcabab","ababcabac","ababcabca","ababcabcb","ababcacab","ababcacac","ababcacba","ababcacbc","ababcbaba","ababcbabc","ababcbaca","ababcbacb","ababcbcab","ababcbcac","ababcbcba","ababcbcbc","abacababa","abacababc","abacabaca","abacabacb","abacabcab","abacabcac","abacabcba","abacabcbc","abacacaba","abacacabc","abacacaca","abacacacb","abacacbab","abacacbac","abacacbca","abacacbcb","abacbabab","abacbabac","abacbabca","abacbabcb","abacbacab","abacbacac","abacbacba","abacbacbc","abacbcaba","abacbcabc","abacbcaca","abacbcacb","abacbcbab","abacbcbac","abacbcbca","abacbcbcb","abcababab","abcababac","abcababca","abcababcb","abcabacab","abcabacac","abcabacba","abcabacbc","abcabcaba","abcabcabc","abcabcaca","abcabcacb","abcabcbab","abcabcbac","abcabcbca","abcabcbcb","abcacabab","abcacabac","abcacabca","abcacabcb","abcacacab","abcacacac","abcacacba","abcacacbc","abcacbaba","abcacbabc","abcacbaca","abcacbacb","abcacbcab","abcacbcac","abcacbcba","abcacbcbc","abcbababa","abcbababc","abcbabaca","abcbabacb"},
            {"ababababab","ababababac","ababababca","ababababcb","abababacab","abababacac","abababacba","abababacbc","abababcaba","abababcabc","abababcaca","abababcacb","abababcbab","abababcbac","abababcbca","abababcbcb","ababacabab","ababacabac","ababacabca","ababacabcb","ababacacab","ababacacac","ababacacba","ababacacbc","ababacbaba","ababacbabc","ababacbaca","ababacbacb","ababacbcab","ababacbcac","ababacbcba","ababacbcbc","ababcababa","ababcababc","ababcabaca","ababcabacb","ababcabcab","ababcabcac","ababcabcba","ababcabcbc","ababcacaba","ababcacabc","ababcacaca","ababcacacb","ababcacbab","ababcacbac","ababcacbca","ababcacbcb","ababcbabab","ababcbabac","ababcbabca","ababcbabcb","ababcbacab","ababcbacac","ababcbacba","ababcbacbc","ababcbcaba","ababcbcabc","ababcbcaca","ababcbcacb","ababcbcbab","ababcbcbac","ababcbcbca","ababcbcbcb","abacababab","abacababac","abacababca","abacababcb","abacabacab","abacabacac","abacabacba","abacabacbc","abacabcaba","abacabcabc","abacabcaca","abacabcacb","abacabcbab","abacabcbac","abacabcbca","abacabcbcb","abacacabab","abacacabac","abacacabca","abacacabcb","abacacacab","abacacacac","abacacacba","abacacacbc","abacacbaba","abacacbabc","abacacbaca","abacacbacb","abacacbcab","abacacbcac","abacacbcba","abacacbcbc","abacbababa","abacbababc","abacbabaca","abacbabacb"}
        };

    public static String getHappyString(int n, int k) {
        n=n-1;
        String [] p =a[n];
        if (p.length < k) return "";
        return p[k - 1];
    }
}
