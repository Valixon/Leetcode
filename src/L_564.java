public class L_564 {
    public static void main(String[] args) {
//        System.out.println(nearestPalindromic("123"));
//        System.out.println(nearestPalindromic("1"));
//        System.out.println(nearestPalindromic("10"));
//        System.out.println(nearestPalindromic("9"));
//        System.out.println(nearestPalindromic("12345678987654321"));
        System.out.println(nearestPalindromic("123892133"));
    }


    public static String nearestPalindromic(String n) {
        int length = n.length();
        if (length == 1) {
            return "" + (Long.parseLong(n) - 1);
        }
        String p = n.replaceAll("0", "");
        if (p.equals("1")) {
            String res = "";
            for (int i = 1; i <= length - 1; i++) {
                res += "9";
            }
            return res;
        }
        if (Long.parseLong(n) < 12) return "9";
        String kichik = "";
        StringBuilder chap = new StringBuilder(n.substring(0, (length + 1) / 2));
        String newN = chap.toString();
        Long a = Long.parseLong(chap.toString());
        if (length % 2 == 0) {
            newN = newN + "" + (chap.reverse());
        } else {
            newN = newN + "" + (chap.reverse().substring(1, chap.length()));
        }
        String katta = "";
        if (Long.parseLong(n) < Long.parseLong(newN)) {
            katta = newN;
        }
        a--;
        if (newN.equals(n)) {
            StringBuilder chap1 = new StringBuilder(a + "");
            if (chap1.length() == chap.length()) {
                kichik = chap1.toString();
                if (length % 2 == 0) {
                    kichik = kichik + "" + (chap1.reverse());
                } else {
                    kichik = kichik + "" + (chap1.reverse().substring(1, chap1.length()));
                }
            } else {
                for (int i = 1; i <= n.length() - 1; i++) {
                    kichik += "9";
                }
            }
        } else {
            if (!katta.isEmpty()){
                StringBuilder chap1 = new StringBuilder(a + "");
                if (chap1.length() == chap.length()) {
                    kichik = chap1.toString();
                    if (length % 2 == 0) {
                        kichik = kichik + "" + (chap1.reverse());
                    } else {
                        kichik = kichik + "" + (chap1.reverse().substring(1, chap1.length()));
                    }
                } else {
                    for (int i = 1; i <= n.length() - 1; i++) {
                        kichik += "9";
                    }
                }
            }else {
                kichik = newN;
            }
        }
        if (katta.isEmpty()) {
            a += 2;
            StringBuilder ong = new StringBuilder(a + "");
            if (ong.length() == chap.length()) {
                katta = ong.toString();
                if (length % 2 == 0) {
                    katta = katta + "" + (ong.reverse());
                } else {
                    katta = katta + "" + (ong.reverse().substring(1, ong.length()));
                }
            } else {
                katta = "1";
                for (int i = 1; i <= n.length() - 1; i++) {
                    katta += "0";
                }
                katta += "1";
            }
        }
        System.out.println(katta);
        System.out.println(kichik);
        if (Long.parseLong(n) - Long.parseLong(kichik) <= Long.parseLong(katta) - Long.parseLong(n)) {
            return kichik;
        }
        return katta;
    }
}