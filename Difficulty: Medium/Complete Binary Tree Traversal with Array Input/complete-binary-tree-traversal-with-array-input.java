class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int index = 0;
        int levelSize = 1;
        int n = arr.length;
        
        while (index < n) {
            
            ArrayList<Integer> level = new ArrayList<>();
            
            int count = Math.min(levelSize, n - index);
            
            for (int i = 0; i < count; i++) {
                level.add(arr[index]);
                index++;
            }
            
            Collections.sort(level);
            ans.add(level);
            
            levelSize *= 2;
        }
        
        return ans;
    }
}