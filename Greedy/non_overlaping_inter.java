class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        //sorting the interval based on there end time
        Arrays.sort(intervals,Comparator.comparingInt(a -> a[1]));

        // rembering the last iterval since we trying the keep the intervals which ends fast
        int previous_interval = 0 ;
        //keeping the count = 1 since there will be atleast one interval after all when a overlaping one is deleted
        int count = 1 ;
        
        for (int i =1 ; i < intervals.length ; i++){
            //checking the last itervals of the 
            // we are checking for the ending itervals of the last 
            // and starting itervals of the current one
            if(intervals[i][0] >= intervals[previous_interval][1]){
                //updating the prev cause we are keeping it since it does not overlap
                count++;
                previous_interval = i;
            }
        }
        return intervals.length - count;
    }
}