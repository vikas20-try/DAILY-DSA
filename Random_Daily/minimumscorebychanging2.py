class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        #here we have question high = maximum diff and low = mini
        #since there are absolutue we are trying to make it>=0
        # so by making any 2 equal we get diff as 0 so low will be always zero
        #when it comes to high diff 
        #here since we are trying reduce the high+low (since low is already 0)
        # we only need to focus on high
        # the highest difference will be when we do nums[n-1] - nums[0]
        #when it is sorted
        # since we alreay plan to make one duplicate we could change the nums[n-1] = nums[n-2] it will going to reduce the diff
        # since also have option to change 2 we could change both nums[n-1] and nums[n-2] as nums[n-3]
        # or we could change the nums[0] to nums[n-1]
        nums.sort()
        n = len(nums)
        return min(nums[n-2]-nums[1],nums[n-3]-nums[0],nums[n-1]-nums[2])
        