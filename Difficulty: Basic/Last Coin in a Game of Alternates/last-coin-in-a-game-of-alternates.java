class Solution {
    public int coin(int[] arr) {
        // code here
                int left = 0, right = arr.length - 1;

        // Continue until only one coin remains
        while (left < right) {
            if (arr[left] >= arr[right]) {
                left++;   // remove left coin
            } else {
                right--;  // remove right coin
            }
        }
        // Only one coin remains
        return arr[left];
    }
}