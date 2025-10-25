class Solution {
    public int minOperations(int[] arr) {
        // code here
         PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double totalSum = 0;

        for (int num : arr) {
            maxHeap.add((double) num);
            totalSum += num;
        }

        double target = totalSum / 2;
        double reducedSum = 0;
        int operations = 0;

        while (reducedSum < target) {
            double largest = maxHeap.poll();
            double halved = largest / 2;
            reducedSum += halved;
            maxHeap.add(halved);
            operations++;
        }

        return operations;
    }
}