class Solution {
    public boolean isProduct(int[] arr, long target) {
        // code here
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        while(left<right){
            long product=(long)arr[left]*arr[right];
            if(product==target){
                return true;
            }else if(product<target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}