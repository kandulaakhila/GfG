class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int maxendinghere=arr[0];
        int maxsofar=arr[0];
        for(int i=1;i<arr.length;i++){
            maxendinghere=Math.max(arr[i],maxendinghere+arr[i]);
            maxsofar=Math.max(maxsofar,maxendinghere);
        }
        return maxsofar;
    }
}
