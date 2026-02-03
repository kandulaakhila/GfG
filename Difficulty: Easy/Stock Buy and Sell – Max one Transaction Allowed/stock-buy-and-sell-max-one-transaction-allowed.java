class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int minprice=Integer.MAX_VALUE;//start with very large number
        int maxprofit=0;
        for(int price:prices){
            if(price<minprice){
                minprice=price;
            }
            else if(price-minprice>maxprofit){
                maxprofit=price-minprice;
            }
    }
    return maxprofit;
}
}