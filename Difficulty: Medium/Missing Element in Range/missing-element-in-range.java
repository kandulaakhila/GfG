class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> result=new ArrayList<>();
        int i=0;
        for(int num=low;num<=high;num++){
            while(i<arr.length && arr[i]<num){
                i++;
            }
                if(i>=arr.length || arr[i]!=num)
                result.add(num);
            }
        return result;
    }
}