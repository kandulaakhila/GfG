class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        //optimal Solution 
        int n = arr.length;

    int[] nse = new int[n]; // next smaller element index
    int[] pse = new int[n]; // previous smaller element index

    // Step 1: Compute NSE (Next Smaller Element)
    Arrays.fill(nse, n);
    Stack<Integer> stack = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            nse[i] = stack.peek();
        }
        stack.push(i);
    }

    // Step 2: Compute PSE (Previous Smaller Element)
    Arrays.fill(pse, -1);
    stack.clear();
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            pse[i] = stack.peek();
        }
        stack.push(i);
    }

    // Step 3: Calculate contributions
    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += (long) arr[i] * (nse[i] - i) * (i - pse[i]);
    }
return (int) sum;
    }
}
