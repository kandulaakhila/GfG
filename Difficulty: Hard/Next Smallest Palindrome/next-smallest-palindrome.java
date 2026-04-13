class Solution {
    static int[] nextPalindrome(int[] num) {
        // code here
        int n=num.length;
        int[] result=Arrays.copyOf(num,n);
        for(int i=0;i<n/2;i++){
            result[n-1-i]=result[i];
        }
        if(isGreater(result, num)){
            return result;
        }
        int mid=n/2;
        int carry=1;
        if(n%2==1){
            result[mid]+=carry;
            carry=result[mid]/10;
            result[mid]%=10;
            mid--;
        }else{
            mid--;
        }
        while(mid>=0 && carry>0){
            result[mid]+=carry;
            carry=result[mid]/10;
            result[mid]%=10;
            mid--;
        }
        if(carry>0){
            int[] newResult=new int[n+1];
             newResult[0] = 1;
            newResult[n] = 1;
            return newResult;
        }

        
        for (int i = 0; i < n / 2; i++) {
            result[n - 1 - i] = result[i];
        }

        return result;
    }
     private static boolean isGreater(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return true;
            if (a[i] < b[i]) return false;
        }
        return false;
    }
}