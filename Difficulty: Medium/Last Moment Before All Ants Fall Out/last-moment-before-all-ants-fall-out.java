class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int lmax=0,rmax=0;
        for(int i:left) lmax=Math.max(lmax,i);
        for(int i:right) rmax=Math.max(rmax,n-i);
        return Math.max(lmax,rmax);
    }
}