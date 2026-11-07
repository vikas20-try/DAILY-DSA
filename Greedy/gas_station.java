//understanding the question neatly 
// we are given gas[] and cost[]
// where gas[i] tell about the gas that the station has 
// cost tell about the cost it will cost to reach it 
// for this we could use a bruete force solution by starting at each position
// but in order to get optimal solution
// first check if the totalcost <= totalgas cause if not we can;t reach it anyways 
// after that we initate the start index to 0 and check 
// for each position if the curr += gas - cost if it is negitive it means we can't go forward
// here if curr is -ve we update the index +1 and curr = 0 and treat that index as new one


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //counting the if it is possible or not
        int totalgas = 0,totalcost = 0;
        for(int i = 0 ; i < gas.length ;i++){
            totalgas += gas[i];
            totalcost += cost[i];
        }
        if(totalcost > totalgas) return -1;
        int startIndex = 0,currentGas = 0;
        for(int i = 0 ; i < gas.length ;i++){
            currentGas += gas[i] - cost[i];
            if(currentGas < 0)//means can't move
            {
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        return startIndex;
    }
}