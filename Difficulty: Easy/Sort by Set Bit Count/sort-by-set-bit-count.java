class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        Integer[] boxedArr=Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr,(a,b)->{
            int bitsA=Integer.bitCount(a);
            int bitsB=Integer.bitCount(b);
            return Integer.compare(bitsB,bitsA);
        });
        ArrayList<Integer>result=new ArrayList<>();
        for(int val:boxedArr){
            result.add(val);
        }
        return result;
    }
}