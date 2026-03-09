class Solution {
    public String largestSwap(String s) {
       char []arr=s.toCharArray();
       int n=arr.length;
       for(int i=0;i<n;i++){
           int maxDigit=arr[i];
           int maxIndex=-1;
       for(int j=i+1;j<n;j++){
           if(arr[j]>=maxDigit){
               maxDigit=arr[j];
               maxIndex=j;
           }
       }
       if(maxIndex!=-1 && arr[maxIndex]>arr[i]){
           char temp=arr[i];
           arr[i]=arr[maxIndex];
           arr[maxIndex]=temp;
           break;
       }
       }
    return new String(arr);
    }
}