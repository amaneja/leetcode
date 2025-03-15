// Best Explanation I found: https://www.youtube.com/watch?v=nbTSfrEfo6M (IDeserve Youtube Channel)
//import java.util.*;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        StringBuilder sPrime = new StringBuilder("#");
        for(char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                //System.out.println("if1: " + i);
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            while(
                i + 1 + palindromeRadii[i] < n &&
                i - 1 - palindromeRadii[i] >= 0 &&
                sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])
                ) {
                    //System.out.println("while: " + i);
                    palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                //System.out.println("if2: " + i);
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        //System.out.println(Arrays.toString(sPrime.toString().toCharArray()));
        //System.out.println(Arrays.toString(palindromeRadii));

        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxLength) / 2;
        //System.out.println("startIndex: " + startIndex + "\nmaxLength: " + maxLength);
        String longestPalindrome = s.substring(startIndex, startIndex + maxLength);

        return longestPalindrome;
    }

    public static void main(String []args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome(new String("bxabaxj")));
    }
}

