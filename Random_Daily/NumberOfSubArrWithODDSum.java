class Solution {
    public int numOfSubarrays(int[] arr) {
        //here we use the prefix sum with the even and odd count
        int prefix = 0,evenCount = 1,oddCount = 0,ans = 0;
        int MOD = 1_000_000_007; // ✅ Recommended
        for(int num : arr){
            prefix += num;
            if(prefix % 2 == 0){
                // sum is even we need to conider oddcount here
                ans = (ans + oddCount)%MOD;
                evenCount++;

            }
            else{
                //need to consider odd count
                ans = (ans + evenCount)%MOD;
                oddCount++;
            }
        }
        return ans;
    }
}