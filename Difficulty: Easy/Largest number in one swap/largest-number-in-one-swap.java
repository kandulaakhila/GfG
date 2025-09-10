class Solution {
    public String largestSwap(String s) {
        // code here
        char[] arr=s.toCharArray();
        int n=arr.length;
        //store last indexof each digit
        int[] lastindex=new int[10];
        for(int i=0;i<n;i++){
            lastindex[arr[i]-'0']=i;
        }
        //traverse and check for largesr digit later
        for(int i=0;i<n;i++){
            for(int d=9;d>arr[i]-'0';d--){
                if(lastindex[d]>i){
                    //swap
                    char temp=arr[i];
                    arr[i]=arr[lastindex[d]];
                    arr[lastindex[d]]=temp;
                    return new String(arr);
                }
            }
        }
        return s;
        
    }
}