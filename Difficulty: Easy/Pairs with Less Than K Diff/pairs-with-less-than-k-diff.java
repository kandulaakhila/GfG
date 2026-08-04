class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int left=0;
        int right=0;
        int count=0;
        while(right<n){
            if(arr[right]-arr[left]<k){
                count+=(right-left);
                right++;
            }
            else{
                left++;
            }
        }
        return count;
    }
}
