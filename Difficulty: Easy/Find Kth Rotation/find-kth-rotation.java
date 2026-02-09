class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n=arr.length;
        int minindex=0;
        for(int i=1;i<n;i++){
            if(arr[i]<arr[minindex]){
                minindex=i;
            }
        }
        return minindex;
    }
}