public class Solution {

    public int reverse(int x) {

        long reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        
        return (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) ? 0 : (int)reversed;

    }

    public static void main(String []args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse( -123456789));
    }
}
