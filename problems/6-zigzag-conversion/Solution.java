import java.util.*;
public class Solution {
    public String convert(String s, int numRows) {
        
        StringBuilder sb = new StringBuilder();
        @SuppressWarnings("unchecked")
        List<Character>[] rows = (List<Character>[]) new List[numRows];
        int k = 0;
        int direction = numRows == 1 ? 0 : -1;

        for (int i = 0; i < numRows; ++i) {
            rows[i] = new ArrayList<>();
        }

        for (final char c : s.toCharArray()) {
            rows[k].add(c);
            if(k == 0 || k == numRows - 1) {
                direction *= -1;
            }
            k += direction;
        }

        for(List<Character> row : rows) {
            for(final char c : row) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public static void main(String []args) {
        Solution sol = new Solution();
        System.out.println(sol.convert(new String("AB"), 1));
    }
}
