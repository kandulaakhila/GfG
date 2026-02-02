class Solution {
    public int maxCircularSum(int arr[]) {
        //Time Complexity: o(n);
        //Space Complexity: o(n);
        // code here
        int totalsum=0;
        int maxNormal=kadaneMax(arr);//case1:non-wrapping
        int minSubarraySum=kadaneMin(arr);//case 2:wrapping
        for (int num : arr)
        totalsum += num;
        int maxWrap = totalsum - minSubarraySum;
        // Edge case: if all numbers are negative, maxWrap becomes 0 (invalid). 
        if (maxNormal < 0) return maxNormal;
        return Math.max(maxNormal, maxWrap);
        }
        
        //kadane's alogrithm for minsubarray sum
        private int kadaneMax(int []arr){
        int currentMax=arr[0];
        int maxsofar=arr[0];
        for(int i=1;i<arr.length;i++){
            currentMax=Math.max(arr[i],currentMax+arr[i]);
            maxsofar=Math.max(maxsofar,currentMax);
        }
        return maxsofar;
        }
        // Kadane’s algorithm for minimum subarray sum
        private int kadaneMin(int[] arr) { 
            int minEndingHere = arr[0], minSoFar = arr[0]; 
            for (int i = 1; i < arr.length; i++) {
                minEndingHere = Math.min(arr[i], 
                minEndingHere + arr[i]); 
                minSoFar = Math.min(minSoFar, minEndingHere);
                } 
                return minSoFar; 
        }
        
    }