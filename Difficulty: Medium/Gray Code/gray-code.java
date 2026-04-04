class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n; // 2^n

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1); // Gray code formula
            // Convert to binary string with leading zeros
            String binary = String.format("%" + n + "s", Integer.toBinaryString(gray))
                                .replace(' ', '0');
            result.add(binary);
        }
        return result;
    }
}