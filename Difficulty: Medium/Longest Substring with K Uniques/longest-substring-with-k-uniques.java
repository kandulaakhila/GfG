class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n=s.length();
        int left=0,maxlen=-1;
        Map<Character, Integer>freq=new HashMap<>();
        for(int right=0;right<n;right++){
            char c=s.charAt(right);
            freq.put(c,freq.getOrDefault(c,0)+1);
            //shrink window if distinct characters exceeds k
            while(freq.size()>k){
                char leftchar=s.charAt(left);
                freq.put(leftchar,freq.get(leftchar)-1);
                if(freq.get(leftchar)==0){
                    freq.remove(leftchar);
                }
                left++;
            }
            //if there are k distict character ,update maxlength
            if(freq.size()==k){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        return maxlen;
    }
}