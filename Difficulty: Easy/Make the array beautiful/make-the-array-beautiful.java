class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
                Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (!stack.isEmpty()) {
                int top = stack.peek();
                // Check if signs differ
                if ((top >= 0 && num < 0) || (top < 0 && num >= 0)) {
                    stack.pop(); // remove both
                    continue;
                }
            }
            stack.push(num);
        }
        
        // Convert stack to list
        return new ArrayList<>(stack);
        
    }
}