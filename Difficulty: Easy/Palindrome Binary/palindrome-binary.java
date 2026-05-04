class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String booleanvalue=Integer.toBinaryString(n);
        if(isPalindrome(booleanvalue)){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean isPalindrome(String s){
        int n=s.length();
        int i=0;
        int j=n-1;
        char[] arr=s.toCharArray();
        while(i<j){
            if(arr[i]!=arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}