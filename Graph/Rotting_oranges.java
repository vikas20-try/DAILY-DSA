class Solution {
    public void dfs(int[][] grid ,int[][] time,int i,int j ,int currentTime){
        //checking 
        if(i<0 || i>= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || currentTime >= time[i][j]) return;
        //since it passed all makign it as rotted as currentTime is given
        time[i][j] = currentTime;
        //doing the dfs
        dfs(grid,time,i+1,j,currentTime+1);
        dfs(grid,time,i-1,j,currentTime+1);
        dfs(grid,time,i,j+1,currentTime+1);
        dfs(grid,time,i,j-1,currentTime+1);
    }
    public int orangesRotting(int[][] grid) {
        // make a copy and fill all of them with inf
        int row = grid.length, col = grid[0].length;
        //making the copy 
        int[][] time = new int[row][col];
        //filling them with inf
        for (int i = 0; i < row ; i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        //going one by one
        for(int i = 0; i < row ;i++){
            for(int j =0 ; j < col ;j++){
                if(grid[i][j]== 2){
                    // 0 is the current_iteration
                    dfs(grid,time,i,j,0);
                }
            }
        }
        //now iterating through the grid to find the max time it took
        int maxTime = 0;
        for(int i = 0; i < row ;i++){
            for(int j =0 ;j < col ;j++){
                //means the we found a good '1'
                if(grid[i][j]==1){
                    if(time[i][j] == Integer.MAX_VALUE) return -1; // means one was never reached
                    maxTime = Math.max(maxTime,time[i][j]);
                }
            }
        }
        return maxTime;
    }
}