import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set to store unique characters in the current window
        HashSet<Character> set = new HashSet<>();

        // Define the max length variable to return the maximum length of the substring
        int maxLength = 0;
        int leftSlider = 0;
        
        // Iterate over the string with the right Slider
        for (int rightSlider = 0; rightSlider < s.length(); rightSlider++) {
            
            if(!set.contains(s.charAt(rightSlider))) {
                set.add(s.charAt(rightSlider));
                maxLength = Math.max(maxLength, rightSlider - leftSlider + 1);
                
            } else {
                while(set.contains(s.charAt(rightSlider))) {
                    set.remove(s.charAt(leftSlider));
                    leftSlider++;
                }
                set.add(s.charAt(rightSlider));
            }
        }


        return maxLength;
    }

    public static void main(String []args) {
        Solution sol = new Solution();
        System.out.println(Integer.toString(sol.lengthOfLongestSubstring(new String("test"))));
    }
}

