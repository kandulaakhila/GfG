class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        //brute force solution(time complexity o(n^2))
        ArrayList<Integer>result=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean leader=true;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    leader=false;
                    break;
                }
            }
            if(leader==true){ 
                result.add(arr[i]);
        }
    }
    return result;
}
}
