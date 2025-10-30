class Solution {
    public void sort012(int[] arr) {
        // code here
        //Dutch National Flag Algorithm
        int low=0, mid=0, high=arr.length-1;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    swap(arr,low++,mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,high--);
                    break;
            }
        }
    }
    private void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}