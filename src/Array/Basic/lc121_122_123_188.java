//package Array.Basic;
//
//public class lc121_122_123_188 {
//    /**
//     * O(n2)
//     * O(1)
//     */
//    public int maxProfit(int[] prices) {
//        if(prices.length <1 || prices== null) return 0;
//        int profit = 0;
//        int sell = prices[0];
//        int buy = prices[0];
//        for(int i = 0 ; i < prices.length; i++){
//            buy = prices[i];
//            for(int j=i+1; j < prices.length; j++){
//                sell =prices[j];
//                profit = Math.max(profit, sell-buy);
//            }
//        }
//        if (profit <0){
//            return 0;
//        }
//        return profit;
//    }
//
//    /**
//     * O(n)
//     * O(1)
//     */
//
//    public int solution2(int[] prices){
//        if (prices == null || prices.length<1) return 0;
//        int min = prices[0];
//        int profit =0;
//
//        for (int price : prices){
//            min = Math.min(min,price);
//            profit = Math.max(profit, price - min);
//        }
//        return profit;
//    }
//
//    public int lc122
//}
