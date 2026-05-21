class Solution {
    public boolean isBitSet(int n) {
        // code here
        if (n==0) return false;
        return((n+1) & n)==0;
    }
};