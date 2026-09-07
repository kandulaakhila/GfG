class Solution {
    public int minCount(int[] arr) {
        // code here
         int n = arr.length;

                // A single 2D array to track state

                int[][] dp = new int[102][102];



                for (int i = n - 1; i >= 0; i--) {

                    // A temporary row clone is only needed if we want to ensure zero-corruption, 

                    // but because we only need the *previous* state, we can use a small 1D array cache 

                    // or a layered update. 

                    int[][] nextDp = new int[102][102];



                    for (int incIdx = 0; incIdx < 102; incIdx++) {

                        for (int decIdx = 0; decIdx < 102; decIdx++) {

                            int inc = (incIdx == 0) ? Integer.MIN_VALUE : incIdx - 1;

                            int dec = (decIdx == 0) ? Integer.MAX_VALUE : decIdx - 1;



                            int skip = dp[incIdx][decIdx];



                            int takeInc = 0;

                            if (arr[i] > inc) {

                                takeInc = 1 + dp[arr[i] + 1][decIdx];

                            }



                            int takeDec = 0;

                            if (arr[i] < dec) {

                                takeDec = 1 + dp[incIdx][arr[i] + 1];

                            }



                            nextDp[incIdx][decIdx] = Math.max(skip, Math.max(takeInc, takeDec));

                        }

                    }

                    dp = nextDp; // Point to the newly computed state

                }



                return n - dp[0][0];

    }
}