class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
       //optimal solution
       int n=arr.length;
       int[] leftmax=new int[n];
       int[] leftmin=new int[n];
       int[] rightmax=new int[n];
       int[] rightmin=new int[n];
       //leftmax
       int currmax=arr[0];
       leftmax[0]=arr[0];
       for(int i=1;i<n;i++){
           currmax=Math.max(arr[i],currmax+arr[i]);
           leftmax[i]=Math.max(leftmax[i-1],currmax);
       }
       //leftmin
       int currmin=arr[0];
       leftmin[0]=arr[0];
       for(int i=1;i<n;i++){
           currmin=Math.min(arr[i],currmin+arr[i]);
           leftmin[i]=Math.min(leftmin[i-1],currmin);
       }
       //Rightmax
       currmax=arr[n-1];
       rightmax[n-1]=arr[n-1];
       for(int i=n-2;i>=0;i--){
           currmax=Math.max(arr[i],currmax+arr[i]);
           rightmax[i]=Math.max(rightmax[i+1],currmax);
       }
       //rightmin
       currmin=arr[n-1];
       rightmin[n-1]=arr[n-1];
       for(int i=n-2;i>=0;i--){
           currmin=Math.min(arr[i],currmin+arr[i]);
           rightmin[i]=Math.min(rightmin[i+1],currmin);
           }
           int ans=Integer.MIN_VALUE;
           for(int i=0;i<n-1;i++){
               ans=Math.max(ans,Math.abs(leftmax[i]-rightmin[i+1]));
               ans=Math.max(ans,Math.abs(leftmin[i]-rightmax[i+1]));
           }
           return ans;
    }
}
       
       

       