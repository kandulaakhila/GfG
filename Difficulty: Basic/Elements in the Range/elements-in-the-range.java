class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
                HashSet<Integer> set = new HashSet<>();
        long sum = 0;

        for (int val : arr) {
            if (val >= start && val <= end) {
                if (!set.contains(val)) {
                    set.add(val);
                    sum += val;
                }
            }
        }
        
        int count = end - start + 1;
        long expectedSum = (long) count * (start + end) / 2;

        return set.size() == count && sum == expectedSum;
    }
}