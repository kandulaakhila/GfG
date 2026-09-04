class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
     int n = arr.size();

     // If m >= n, take all trees
     if (m >= n) {
         int total = 0;

         for (int i = 0; i < n; i++) {
             total += arr.get(i);
         }

         return total;
     }

     // First window
     int sum = 0;

     for (int i = 0; i < m; i++) {
         sum += arr.get(i);
     }

     int maxSum = sum;
// Slide window
        for (int i = 1; i < n; i++) {

            int removeIndex = i - 1;
            int addIndex = (i + m - 1) % n;

            sum -= arr.get(removeIndex);
            sum += arr.get(addIndex);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}