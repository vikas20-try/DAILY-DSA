class Solution {
    public int lengthOfLIS(int[] nums) {
        //make a dp and fill them with 1 cause it is minimum length an arr will have even without asequence 
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //starting the loop
        for(int i = 1; i < nums.length ;i++){
            for(int j = 0 ; j < i ;j++){
                if(nums[i] > nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        //finnding the max
        int maxSeq= 0;
        for(int i = 0 ; i < nums.length ;i++){
            if(dp[i]>maxSeq) maxSeq = dp[i];
        }
        return maxSeq;

    }
}