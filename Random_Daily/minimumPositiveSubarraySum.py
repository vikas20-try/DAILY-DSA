class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        #first approah the is coming to my mind is for * for loop inside the while loop and till the r-l+1 times cause
        minSum = float('inf')
        for i in range(r-l+1):
            left = 0
            right = l+i
            #for the first right elements
            sum = 0
            for k in range(right):
                sum += nums[k]
            if sum > 0:
                minSum = min(minSum,sum)
            while right < len(nums) and left < right:
                #removing the left element
                sum -= nums[left]
                #adding the right 
                sum += nums[right]
                if sum > 0:
                    minSum = min(sum,minSum)
                right +=1
                left += 1
        return -1 if minSum == float('inf') else minSum
                            

        
