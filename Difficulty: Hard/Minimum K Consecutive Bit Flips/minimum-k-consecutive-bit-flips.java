class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
         int n = arr.length;
        int res = 0;          // number of flips performed
        int flipCount = 0;    // active flips affecting current index
        int[] diff = new int[n + 1]; // difference array to mark flip ends

        for (int i = 0; i < n; i++) {
            flipCount += diff[i]; // update active flips at position i

            // effective bit after considering flips
            int bit = (arr[i] + flipCount) % 2;

            if (bit == 0) { // need to flip here
                if (i + k > n) return -1; // not enough space to flip
                res++;
                flipCount++;
                diff[i + k]--; // mark that flip effect ends at i+k
            }
        }
        return res;
    }
}