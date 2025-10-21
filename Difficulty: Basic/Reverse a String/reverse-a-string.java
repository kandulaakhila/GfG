// User function Template for Java

class Solution {
    public static String reverseString(String s) {
        // code here
        //convert string to character array;
        char[] chars=s.toCharArray();
        //two pointer technique to reverse in place;
        int left=0;
        int right=chars.length-1;
        while(left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        //convert back in to string;
        return new String(chars);
        
        
    }
}