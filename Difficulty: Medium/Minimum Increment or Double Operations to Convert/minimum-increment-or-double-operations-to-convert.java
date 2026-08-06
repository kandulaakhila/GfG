class Solution {
    public int countMinOperations(int arr[]) {
        // code here
        int n=arr.length;
        int dbl=0;
        int sin=0;
        for(int ind=0;ind<n;ind++){
            int cnt=0;
            int val=arr[ind];
            while(val!=0){
                if(val%2!=0){
                    sin++;
                    val--;
                }
                else{
                    cnt++;
                    val/=2;
                }
            }
            dbl=Math.max(dbl,cnt);
        }
        return dbl+sin;
    }
}