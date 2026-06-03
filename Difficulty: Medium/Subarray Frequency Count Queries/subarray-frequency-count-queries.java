class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
         Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];
            
            if (!map.containsKey(x)) {
                result.add(0);
                continue;
            }
            ArrayList<Integer> positions = map.get(x);
            
            int left = lowerBound(positions, l);
            int right = upperBound(positions, r);
            
            result.add(right - left);
        }
        return result;
    }
    private int lowerBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private int upperBound(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}