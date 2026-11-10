class Solution {
    public int[][] merge(int[][] intervals) {
        // checking if it is 1 or less than that
        if(intervals.length <=1) return intervals;
        //sorting the arr based on the starting time this time 
        // since we ourself are doing the overlap
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        // making the result arr
        List<int[]> result = new ArrayList<>();
        //making the interval which can dynamically change the input inside the result
        int[] newIntervals = intervals[0];
        result.add(newIntervals);
        for (int[] interval : intervals){
            //checking if they overlap
            if(newIntervals[1]>= interval[0]){
                // it means they are overlapping
                // so update the new overlap
                newIntervals[1] = Math.max(newIntervals[1],interval[1]);
            }
            else{
                //updating the new interval a part where we move to next part also
                newIntervals = interval;
                result.add(newIntervals);
                //here also with the help of this we can dynamically update the intervals
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}