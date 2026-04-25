class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // code here
         Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            boolean add = true;
            while (!stack.isEmpty() && ((stack.peek() > 0 && num < 0) || (stack.peek() < 0 && num > 0))) {
                int top = stack.peek();
                if (Math.abs(top) == Math.abs(num)) {
                    stack.pop();
                    add = false;
                    break;
                } else if (Math.abs(top) > Math.abs(num)) {
                    add = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (add) stack.push(num);
        }
        return new ArrayList<>(stack);
    }
}