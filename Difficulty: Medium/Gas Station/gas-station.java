class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
        int totalgas=0,totalcost=0;
        int tank=0,start=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
            tank+=gas[i]-cost[i];
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return totalgas>=totalcost?start:-1;
    }
}