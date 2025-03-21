public class MySolution {

    public int myAtoi(String s) {
        if (s.length() > 200) {
            return 0;
        }

        int idx = 0;
        int sign = 1;
        long answer = 0;

        while (Character.isWhitespace(s.charAt(idx)) && idx <= s.length() - 1) {
            idx++;
            if (idx == s.length()) {
                return 0;
            }
        }
        sign = s.charAt(idx) == '-' ? -1 : 1;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-' ) {
            idx++;
        }

        for (int i = idx; i < s.length(); i++) {

            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            answer = answer * 10 + s.charAt(i) - '0';

            if (sign * answer <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * answer >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

        }
        return sign * (int)answer;
    }

    public static void main(String []args) {
        MySolution sol = new MySolution();
        System.out.println(sol.myAtoi("42"));
        System.out.println(sol.myAtoi("   -042"));
        System.out.println(sol.myAtoi("1337c0d3"));
        System.out.println(sol.myAtoi("0-1"));
        System.out.println(sol.myAtoi("words and 987"));
    }
}
