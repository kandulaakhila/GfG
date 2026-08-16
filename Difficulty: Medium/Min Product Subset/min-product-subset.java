class Solution {
    public int minProd(int[] arr) {
        // code here
        int negativeCount = 0;
        int negativeProduct = 1;
        int largestNegative = Integer.MIN_VALUE;

        int positiveProduct = 1;
        int smallestPositive = Integer.MAX_VALUE;

        boolean hasZero = false;

        for (int num : arr) {

            if (num < 0) {
                negativeCount++;
                negativeProduct *= num;
                largestNegative = Math.max(largestNegative, num);

            } else if (num == 0) {
                hasZero = true;

            } else {
                positiveProduct *= num;
                smallestPositive = Math.min(smallestPositive, num);
            }
        }

        // No negative numbers
        if (negativeCount == 0) {
            if (hasZero) {
                            return 0;
                        }
                        return smallestPositive;
                    }

                    // Odd number of negatives
                    if (negativeCount % 2 == 1) {
                        return negativeProduct * positiveProduct;
                    }

                    // Even number of negatives
                    negativeProduct /= largestNegative;
                    return negativeProduct * positiveProduct;
                
        
        
    }
}