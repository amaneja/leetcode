import java.util.Arrays;

public class MySolution {

    public String convert(String s, int numRows) {
        String zigZag = "";

        String rows[] = new String[numRows];
        Arrays.fill(rows, "");
        int strPtr = 0;
        boolean directionUp = false; // false means down
        int row = 0;

        while (row < rows.length) {

            if (row < 0 || row == rows.length) {
                return s;
            }

            // Keep writing data row-wise Down or Up
            rows[row] = rows[row] + s.charAt(strPtr) + " ";

            if (row == 0) {
                directionUp = false;
            }

            if (row == rows.length - 1) {
                directionUp = true;
            }

            if (directionUp) {
                //rows[row] = rows[row] + String.valueOf("  ").repeat(row - 1); // Can be commented LeetCode didn't support
                row--;
            } else {
                //rows[row] = rows[row] + String.valueOf("  ").repeat(rows.length - 2 - row); // Can be commented LeetCode didn't support
                row++;
            }

            // Traverse to the strings next character
            strPtr++;

            if (strPtr == s.length()) {
                row = rows.length;
                // Strings bounds have been reached. Logic to read the arrays and return.
                for (String lines: rows) {
                    System.out.println(lines);  // Comment this if submitting to LeetCode
                    zigZag = zigZag + lines;
                }
            }
        }

        return zigZag.replace(" ", "");
    }

    public static void main(String []args) {
        MySolution sol = new MySolution();
        System.out.println(sol.convert(new String("AB"), 1));
    }
}
