class Solution {
    public int minMoves(int[] arr) {
        // code here
        //brute force 
        int n=arr.length;
        int pos[]=new int[n+1];
        for(int i=0;i<n;i++){
            pos[arr[i]]=i;
        }
        int maxlen=1;
        for(int start=1;start<=n;start++){
        int length=1;
        for(int value=start;value<n;value++){
            if(pos[value]<pos[value+1]){
                length++;
            }else{
            break;
            }
            maxlen=Math.max(maxlen,length);
        }
        }
        return n-maxlen;
    }
}