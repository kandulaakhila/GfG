class Solution {
    public int getCount(int n) {
        //optimal solution
         int left = 1;
        int right = 1;

        int sum = 1;

        int count = 0;

        while (left <= n / 2) {

            if (sum < n) {

                right++;
                sum += right;
            }

            else if (sum > n) {

                sum -= left;
                left++;
            }

            else {

                if (right > left)
                    count++;

                sum -= left;
                left++;
            }
        }

        return count;
    }
}