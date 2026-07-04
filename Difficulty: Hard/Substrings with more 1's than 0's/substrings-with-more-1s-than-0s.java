class Solution {
    public int countSubstring(String s) {
        // code here
         int n = s.length();

        // Only one array needed for frequency tracking

        int[] freq = new int[2 * n + 1];

        

        int currentSum = 0;

        long invalid = 0;

        

        // Step 1: Count prefix sum frequencies dynamically

        for (int i = 0; i < n; i++) {

            currentSum += (s.charAt(i) == '1') ? 1 : -1;

            freq[currentSum + n]++;

            

            if (currentSum <= 0) {

                invalid++;

            }

        }

        

        long totalSubstrings = 0;

        int threshold = 0;

        currentSum = 0; // Reuse variable to re-track prefix during sliding

        

        // Step 2: Slide window and update counts inline

        for (int i = 0; i < n; i++) {

            totalSubstrings += ((n - i) - invalid);

            

            // Re-evaluate prefix sum for index i without an extra array

            currentSum += (s.charAt(i) == '1') ? 1 : -1;

            freq[currentSum + n]--;

            

            if (currentSum <= threshold) {

                invalid--;

            }

            

            // Shift baseline threshold

            if (s.charAt(i) == '1') {

                threshold += 1;

                invalid += freq[threshold + n];

            } else {

                invalid -= freq[threshold + n];

                threshold -= 1;

            }

        }

        

        return(int) totalSubstrings;
    }
}