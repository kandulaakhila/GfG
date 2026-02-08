class Solution {
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
        int max_so_far=arr[0];
        int max_ending_here=arr[0];
        int min_ending_here=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<0){
                int temp=max_ending_here;
                max_ending_here=min_ending_here;
                min_ending_here=temp;
            }
            max_ending_here=Math.max(arr[i],max_ending_here*arr[i]);
            min_ending_here=Math.min(arr[i],min_ending_here*arr[i]);
            max_so_far=Math.max(max_so_far,max_ending_here);
        }
        return max_so_far;
}
}