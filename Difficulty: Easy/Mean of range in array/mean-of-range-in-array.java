class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int[] prefix = new int[n];
        
        // Build prefix sum array
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Answer each query in O(1)
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int sum = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
            int mean = sum / (r - l + 1); // floor division
            result.add(mean);
        }
        
        return result;
        
    }
}