/**
 * Created by lunwang on 11/5/2014.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int cur = 0, st = 0, pa = 0, star = -1;
        while(st < s.length()) {
            if (pa < p.length() && p.charAt(pa) == '*') {
                star = pa;
                cur = st;
                pa++;
            } else if (pa < p.length() && (p.charAt(pa) == '?' || p.charAt(pa) == s.charAt(st))) {
                st++;
                pa++;
            } else if (star != -1) {
                pa = star + 1;
                st = ++cur;
            } else return false;
        }
        while(pa != p.length() && p.charAt(pa)=='*'){
            pa++;
        }
        return pa == p.length();

    }
}
