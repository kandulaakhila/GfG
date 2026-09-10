class Solution {
    static int gcd(int a, int b) {
           while (b != 0) {
               int temp = a % b;
               a = b;
               b = temp;
           }
           return a;
       }
    public int pairCount(int x, int y) {
        // code here
        if (y % x != 0)
                    return 0;

                int n = y / x;
                int count = 0;

                for (int p = 1; p * p <= n; p++) {

                    if (n % p == 0) {

                        int q = n / p;

                        if (gcd(p, q) == 1) {

                            if (p == q)
                                count++;
                            else
                                count += 2;
                        }
                    }
                }

                return count;
        
    }
}