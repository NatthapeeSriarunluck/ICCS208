import java.util.Locale;

public class Hidden {
    public static boolean isHidden(String s, String t) {
        String compare = "";
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    compare += (t.charAt(i));
                    break;
                }
            }
        }
        return compare.equals(t);
    }
}
