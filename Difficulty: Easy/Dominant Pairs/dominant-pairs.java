class Solution {
    public int dominantPairs(int[] arr) {
        // Code here
       
               int n = arr.length;
               int half = n / 2;

               // Sort both halves
               Arrays.sort(arr, 0, half);
               Arrays.sort(arr, half, n);

               int j = half;
               int count = 0;

               // For every element in first half
               for (int i = 0; i < half; i++) {

                   while (j < n && arr[i] >= 5L * arr[j]) {
                       j++;
                   }

                   // All elements from half to j-1 are valid
                   count += j - half;
               }

               return count;
           }
       }