class Solution {
    public boolean canJump(int[] nums) {
        // by the greedy approcach we will check if it is possible to reach the last from the last itself
        int final_point = nums.length-1;//last position
        for(int i = nums.length-2;i >= 0 ;i--){
            //checking if it is possible to reach the last and while updating what is our last is 
            if(nums[i]+i >= final_point){
                final_point = i;
            }
        }
        return final_point == 0 ;
    }
}