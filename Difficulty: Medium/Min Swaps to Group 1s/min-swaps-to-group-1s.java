class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int n=arr.length;
        int countOnes = 0;
        for (int num : arr) {
            if (num == 1) countOnes++;
        }
        
        if (countOnes == 0) return -1; 
        
        
        int currentOnes = 0;
        for (int i = 0; i < countOnes; i++) {
            if (arr[i] == 1) currentOnes++;
        }
        
        int maxOnesInWindow = currentOnes;
        for (int i = countOnes; i < n; i++) {
            if (arr[i] == 1) currentOnes++;              
            if (arr[i - countOnes] == 1) currentOnes--; 
            
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }
        
        
        return countOnes - maxOnesInWindow;
    }
}
