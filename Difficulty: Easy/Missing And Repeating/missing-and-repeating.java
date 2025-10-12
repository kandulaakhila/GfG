class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        HashSet<Integer> seen = new HashSet<>();
        int duplicate = 0;
        long sum = 0;
        long expectedSum = (long) n * (n + 1) / 2;

        for (int num : arr) {
            sum += num;        
            if (!seen.add(num)) {
                duplicate = num;
            }
        }

        long uniqueSum = sum - duplicate;
        int missing = (int) (expectedSum - uniqueSum);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);
        return result;
    }
}
