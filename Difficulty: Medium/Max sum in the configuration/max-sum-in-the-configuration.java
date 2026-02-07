class Solution {
    int maxSum(int[] arr) {
        // code here
        int n=arr.length;
        int sum=0;
        for(int num:arr) sum+=num;
        int f=0;
        for(int i=0;i<n;i++){
            f+=i*arr[i];
        }
        //compute all rotations using recurrence
        int max=f;
        for(int k=1;k<n;k++){
            f=f+sum-n*arr[n-k];
            max=Math.max(max,f);
        }
        return max;
    }
}