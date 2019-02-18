public class SolutionRex {
    public static void main(String... args) {
        String s = "mississippi";
        String p = "mis*is*ip*.";

        boolean r = new Solution().isMatch(s, p);
        System.out.println(r);
    }

    static class Solution {
        public boolean isMatch(String s, String p) {
            return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
        }

        private boolean isMatch(char[] s, int si, char[] p, int pi) {
            while (si < s.length && pi < p.length) {
                if (pi < p.length-1 && p[pi+1] == '*') {
                    // * pattern match (recursion)
                    char rep = p[pi];
                    pi += 2;
                    do {
                        if (isMatch(s, si, p, pi)) return true;
                        if (!chMatch(s[si], rep)) break;
                        si++;
                    } while (si < s.length);
                    return pi == p.length;
                } else {
                    if (!chMatch(s[si++], p[pi++])) return false;
                }
            }
            return si == s.length && pi == p.length;
        }

        private boolean chMatch(char s, char p) {

            if (p == '.') {
                return true;
            } else {
                return p == s;
            }
        }
    }
}
