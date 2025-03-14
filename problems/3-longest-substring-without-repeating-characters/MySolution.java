import java.util.*;

class MySolution {
    public int lengthOfLongestSubstring(String s) {

        // Define the max length variable to return the maximum length of the substring
        int maxLen = 0;
        int arrayIndex = 0;
        
        // Array to capture all possible substring.
        String[] allStrings = new String[s.length() * 2 - 1];
        
        // Capture strings starting from the first character
        for (int i = 1; i <= s.length(); i++) { // less than equal bcoz of substring's working 
            allStrings[arrayIndex] = s.substring(0, i);
            arrayIndex += 1;
        }
        
        // Capture strings starting from the last character to the second character.
        for (int i = s.length() - 1; i > 0; i--) { 
            allStrings[arrayIndex] = s.substring(i, s.length());
            arrayIndex += 1;
        }

        for(int j = 0; j < allStrings.length; j++) {
            Map<Character, Integer> uniqueChars = new HashMap<>();
            for(int k = 0; k < allStrings[j].length(); k++) {
                
                // Add each character of the current string to HashMap
                uniqueChars.put(allStrings[j].charAt(k), 0);
                
                // Compare the length of string to HashMap. Update maxLen if its equal
                if (allStrings[j].length() == uniqueChars.size()) {
                    
                }
            }
            maxLen = uniqueChars.size();
        }
        return maxLen;
    }

    public static void main(String []args) {
        MySolution sol = new MySolution();
        System.out.println(Integer.toString(sol.lengthOfLongestSubstring(new String("Test"))));
    }
}

