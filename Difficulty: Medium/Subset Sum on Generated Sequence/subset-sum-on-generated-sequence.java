class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        int n = arr.length;

        // Store generated numbers
        long[] nums = new long[n + 1];

        nums[0] = s;

        long sum = s;

        // Generate the sequence
        for (int i = 0; i < n; i++) {
            long next = sum + arr[i];

            nums[i + 1] = next;

            sum += next;

            // We don't need numbers greater than x
            if (sum > x && next > x) {
                // Continue generating is unnecessary
                // because all future numbers will also be > x
                break;
            }
        }

        // Greedy subset sum
        long remaining = x;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] <= remaining) {
                remaining -= nums[i];
            }

            if (remaining == 0) {
                return true;
                    }
                }

                return false;
        
    }
}