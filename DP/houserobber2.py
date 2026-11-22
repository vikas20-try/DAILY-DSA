class Solution:
    def robber(self,nums):
        n = len(nums)
        if n == 0:
            return 0
        if n == 1:
            return nums[0]
        dp = [ 0  for _ in range(n)]
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2,n):
            dp[i] = max(nums[i]+dp[i-2],dp[i-1])
        return dp[n-1]
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n < 2:
            return nums[0]
        skipFirst = [0 for _ in range(n-1)]
        skipLast = [0 for _ in range(n-1)]
        for i in range(n-1):
            skipFirst[i] = nums[i+1]
            skipLast[i] = nums[i]
        firstOut = self.robber(skipFirst)
        lastOut = self.robber(skipLast)
        return max(firstOut,lastOut)