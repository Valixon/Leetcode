public class L_1813 {
    public static void main(String[] args) {
        System.out.println(areSentencesSimilar("My name is HaleyMy name is Haley", "My Haley"));
        System.out.println(areSentencesSimilar("of", "A lot of words"));
        System.out.println(areSentencesSimilar("Eating right now", "Eating"));
    }


    public static boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }
        if (s1.length() < s2.length()) {
            String s3 = s1;
            s1 = s2;
            s2 = s3;
        }
        String[] a = s1.split(" ");
        String[] b = s2.split(" ");
        int left = 0;
        for (int i = 0; i < b.length; i++) {
            if (a[i].equals(b[i])) {
                left++;
            } else break;
        }
        int x = 0;
        for (int i = b.length - 1; i >= left; i--) {
            x++;
            if (!a[a.length - x].equals(b[i])) {
                return false;
            }
        }
        return true;
    }
}
