// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int i=0;
        int j=m-1;
        int min=Integer.MAX_VALUE;
        while(j<arr.size()){
         min=Math.min(min,arr.get(j)-arr.get(i));
            i++;
            j++;
        }
        return min;
    }
}