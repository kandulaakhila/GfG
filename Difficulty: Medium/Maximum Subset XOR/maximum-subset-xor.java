class Solution {
    public int maxSubsetXOR(int[] arr) {
        // code here
         int index = 0;
        int n = arr.length;
        // Build XOR Basis
        for (int bit = 31; bit >= 0; bit--) {

            int maxIndex = index;

            while (maxIndex < n &&
                  ((arr[maxIndex] & (1 << bit)) == 0)) {
                maxIndex++;
            }

            if (maxIndex == n)
                continue;

            // Swap pivot
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;

            // Eliminate current bit
            for (int i = 0; i < n; i++) {

                if (i != index &&
                   ((arr[i] & (1 << bit)) != 0)) {

                    arr[i] ^= arr[index];
                   }
            }

            index++;
        }

        int ans = 0;

        // Greedily maximize XOR
        for (int x : arr) {

            if ((ans ^ x) > ans)
                ans ^= x;
        }

        return ans;
        
    }
}