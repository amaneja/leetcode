class Solution {
    public int myAtoi(String s) {
    s = s.strip();
    if (s.isEmpty())
      return 0;

    final int sign = s.charAt(0) == '-' ? -1 : 1;
    if (s.charAt(0) == '+' || s.charAt(0) == '-')
      s = s.substring(1);

    long num = 0;

    for (final char c : s.toCharArray()) {
      if (!Character.isDigit(c))
        break;
      num = num * 10 + (c - '0');
      if (sign * num <= Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
      if (sign * num >= Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
    }

    return sign * (int) num;
    }

    public static void main(String []args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("42"));
        System.out.println(sol.myAtoi("   -042"));
        System.out.println(sol.myAtoi("1337c0d3"));
        System.out.println(sol.myAtoi("0-1"));
        System.out.println(sol.myAtoi("words and 987"));
    }
}