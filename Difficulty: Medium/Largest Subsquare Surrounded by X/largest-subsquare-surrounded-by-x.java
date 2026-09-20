class Solution {
    public int largestSubsquare(char mat[][]) {
        // code here
        int n = mat.length;

               int[][] right = new int[n][n];
               int[][] down = new int[n][n];

               // Build right[][]
               for (int i = 0; i < n; i++) {

                   for (int j = n - 1; j >= 0; j--) {

                       if (mat[i][j] == 'X') {

                           right[i][j] = 1;

                           if (j + 1 < n) {
                               right[i][j] += right[i][j + 1];
                           }
                       }
                   }
               }
               // Build down[][]
                      for (int j = 0; j < n; j++) {

                          for (int i = n - 1; i >= 0; i--) {

                              if (mat[i][j] == 'X') {

                                  down[i][j] = 1;

                                  if (i + 1 < n) {
                                      down[i][j] += down[i + 1][j];
                                  }
                              }
                          }
                      }

                      int max = 0;

                      // Try every top-left corner
                      for (int i = 0; i < n; i++) {

                          for (int j = 0; j < n; j++) {
// Try every possible size
              for (int size = 1;
                   i + size <= n && j + size <= n;
                   size++) {

                  int bottom = i + size - 1;
                  int rightCol = j + size - 1;

                  if (right[i][j] >= size &&
                      right[bottom][j] >= size &&
                      down[i][j] >= size &&
                      down[i][rightCol] >= size) {

                      max = Math.max(max, size);
                  }
              }
          }
      }

      return max;
        
    }
};