

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        //Keep this for later, here we will call current functions with switched parameters
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
 
        int low = 0;
        int high = m;

        // This loop will run till low is greater which will mean that input arrays are not sorted
        while(low <=  high) {
            //Find initial partitions, short array nums1 uses binary search and long array nums2 depends on nums1
            int partitionM = (low + high) / 2;
            int partitionN = ((m + n + 1) / 2) - partitionM;

            // Determine maxLeft and minRight for each arrays
            int maxLeftM = (partitionM == 0) ? Integer.MIN_VALUE : nums1[partitionM - 1];
            int minRightM = (partitionM == m) ? Integer.MAX_VALUE : nums1[partitionM];

            int maxLeftN = (partitionN == 0) ? Integer.MIN_VALUE : nums2[partitionN - 1];
            int minRightN = (partitionN == n) ? Integer.MAX_VALUE : nums2[partitionN];

            // Check conditions to find the median
            if (maxLeftM <= minRightN && maxLeftN <= minRightM) {
                // Bingo, this is the correct partition
                // Let's see if the total length of arrays is even or add
                if ((m + n) % 2 == 0) {
                    // Even
                    return ((double)(Math.max(maxLeftM, maxLeftN) + Math.min(minRightM, minRightN)) / 2);
                } else {
                    // Odd
                    return ((double)Math.max(maxLeftM, maxLeftN));
                }
            } else if(maxLeftM > minRightN) {
                // Max Short Array is greater; let's move to the left
                high = partitionM - 1;
            } else {
                // Max Short Array is lesser; let's move to the right
                low = partitionM + 1;
            }
        }

        // Input arrays are not sorted
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Double.toString(sol.findMedianSortedArrays(new int[]{3, 5, 7, 9}, new int[]{23, 26, 31, 35, 38, 40})));
    }
}
