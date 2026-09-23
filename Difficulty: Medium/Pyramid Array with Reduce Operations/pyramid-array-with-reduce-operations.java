class Solution {
    public int formPyramid(int[] arr) {
        // code here
        int n = arr.length;

               int[] left = new int[n];
               int[] right = new int[n];

               // Total sum of the original array
               long sum = 0;

               for (int x : arr) {
                   sum += x;
               }

               // Maximum possible height from the left
               left[0] = 1;

               for (int i = 1; i < n; i++) {
                   left[i] = Math.min(arr[i], left[i - 1] + 1);
               }

               // Maximum possible height from the right
               right[n - 1] = 1;
               
                   for (int i = n - 2; i >= 0; i--) {
                       right[i] = Math.min(arr[i], right[i + 1] + 1);
                   }

                   // Find the maximum possible pyramid height
                   int maxHeight = 0;

                   for (int i = 0; i < n; i++) {
                       int height = Math.min(left[i], right[i]);
                       maxHeight = Math.max(maxHeight, height);
                   }

                   // Sum of a pyramid of height h is h^2
                   long pyramidSum = (long) maxHeight * maxHeight;

             
             return (int)(sum - pyramidSum);
    }
};