class MySolution {
    public String longestPalindrome(String s) {

        // If the whole string is a palindrome, it's the longest.
        if (checkPalindrome(s) || s.length() <= 1) {
            return s;
        }

        int maxLength = 0;
        String maxString = "";

        // Check each string from second character to second to the last character
        for (int i = 0; i <= s.length() - 2; i++) {
            String temp = "";
            for(int read = 0 ; read <= i; read++) {
                temp = temp + s.charAt(read);
            }
            if (checkPalindrome(temp) && maxLength < temp.length()) {
                maxString = temp;
                maxLength = temp.length();
            }
        }

        // Check each string from second character to end
        for (int i = 1; i <= s.length() - 1; i++) {
            String temp = "";
            for(int read = 1 ; read <= i; read++) {
                temp = temp + s.charAt(read);
            }
            if (checkPalindrome(temp) && maxLength < temp.length()) {
                maxString = temp;
                maxLength = temp.length();
            }
        }

        return maxString;
    }

    public boolean checkPalindrome(String inpStr) {
        
        String reversedStr = new String();
        for (int i = inpStr.length() - 1; i >= 0 ; i--) {
            reversedStr = reversedStr + inpStr.charAt(i);
        }

        return inpStr.equals(reversedStr);
    }

    public static void main(String []args) {
        MySolution sol = new MySolution();
        System.out.println(sol.longestPalindrome(new String("malayalam")));
    }
}

