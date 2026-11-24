class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1 ) return 0;
        int[] minCount = new int[amount+1];
        for(int i = 1; i <= amount ;i++){
            minCount[i] = Integer.MAX_VALUE;
            for(int coin : coins){
                if( i >= coin && minCount[i-coin] != Integer.MAX_VALUE){
                    minCount[i] = Math.min(minCount[i],minCount[i-coin]+1);
                }
            }
        }
        if(minCount[amount] == Integer.MAX_VALUE) return -1;
        return minCount[amount];
    }
}