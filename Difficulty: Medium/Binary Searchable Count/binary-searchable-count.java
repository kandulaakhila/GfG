class Solution {
   private boolean check(int key, int[] arr, int n) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == key) return true;
            if (arr[mid] < key) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

   
    public int binarySearchable(int[] arr) {
        int n = arr.length, cnt = 0;
        for (int x : arr) {
            if (check(x, arr, n)) cnt++;
        }
        return cnt;
    }
}