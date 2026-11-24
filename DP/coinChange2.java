class Solution {
    public int change(int amount, int[] coins) {
     //instead of minimum coin count we check for ways to make up a amounts comnination
     int[] dp = new int[amount+1];
     //makeing the dp[0] =1 
     dp[0] = 1;
     //going through each coin
     for(int coin : coins){
        for(int i = coin ; i <= amount ;i++){
            dp[i] = dp[i] + dp[i-coin]; //checking the i-coin combination
        }
     } 
     return dp[amount];  
    }
}