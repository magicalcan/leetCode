/**
 * Created by lunwang on 10/22/2014.
 */
public class BestTimetoBuyandSellStockIII {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int result = 0;
        int low = prices[0];
        int[] maxProfits = new int[prices.length];
        for(int i=0; i<prices.length; i++){        //profit from first transaction
            if(prices[i]<low) low = prices[i];
            int temp = prices[i] - low;
            result = result>=temp? result:temp;
            maxProfits[i] = result;
        }
        int high = prices[prices.length-1];
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i]>high) high = prices[i];
            int temp = high - prices[i] + maxProfits[i];    //add profit from the second transaction
            result = result>temp? result:temp;
        }
        return result;
    }
}
