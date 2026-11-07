//in the jump game 2 
// we are given a arr of 0-index and we are currently at index 0 or nums[0] for length 'n'
//each index nums[i] talks about the maximum jump it can make from the 'i' th index
// means i can jump upto (i+j) length where  0<j<nums[i] means it can jump whatever we want 
//return the minimum number or jumps required to reach n-1 pos (means the last index)
//unlike the jump 1 it is generate that we will reach the n-1 
//but need to find the minimum jump required
/////////////////////////////////////////////////////////////////
/// the method used here is the window with the help of two pointer
/// means like [2,3,1,1,4] here the left and right will going to be in first are at [2,3] here 
/// [2,3] we check for the farthest we can jump which is 3 now the left from 2 will become right +1 
/// left = right + 1 and left = nums[i]+ i of the farthest 
/// now the left and right pointer will be at [1,1,4] since the right is already in the window of the last
/// it will become the ans

class Solution {
    public int jump(int[] nums) {
        int count = 0;
        //to minimize the count we have to choose the maximum steps 
        int left = 0;
        int right = 0;
        while(right < nums.length -1){
            int farthest = 0;
            for(int i = left ; i <= right ;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            left = right + 1;
            right  = farthest ;
            count++;
        }
        return count;
    }
}
