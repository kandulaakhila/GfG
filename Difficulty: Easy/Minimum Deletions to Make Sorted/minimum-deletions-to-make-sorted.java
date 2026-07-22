class Solution {
    public int minDeletions(int[] arr) {
        // code here
        ArrayList<Integer>tails=new ArrayList<>();
        for(int num:arr){
            int left=0;
            int right=tails.size()-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(tails.get(mid)>=num)right=mid-1;
                else
                left=mid+1;
            }
            if(left==tails.size())
            tails.add(num);
            else
            tails.set(left,num);
        }
        return arr.length-tails.size();
    }
}