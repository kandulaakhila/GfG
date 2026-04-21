class Solution {
    // GCD function
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Main function to find minimum steps
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;

        int ans1 = solve(m, n, d);
        int ans2 = solve(n, m, d);
        return Math.min(ans1, ans2);
    }

    // Simulation function
    public int solve(int fromCap, int toCap, int d) {
        int from = fromCap;  // fill from jug
        int to = 0;          // to jug empty
        int steps = 1;       // initial fill

        while (from != d && to != d) {
            int temp = Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            steps++;

            if (from == d || to == d) break;

            if (from == 0) {
                from = fromCap;
                steps++;
            }

            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }
}
