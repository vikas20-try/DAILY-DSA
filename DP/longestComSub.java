class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = 1 ; i <= text1.length() ;i++){
            for(int j = 1 ; j <= text2.length() ;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    //checking two elements are equal? or not if yes then add +1 from last
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    //checking which is max top or left
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }
}