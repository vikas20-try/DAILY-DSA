class Solution {
    public void dfs(char[][] grid ,int i,int j){
        //return statement 
        //since we looking for the neighbour by doig i-1 or i +1 or j-1 or j+1
        if(i<0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] == '0') return;
        //since it passed all the above required critiria we make [i][j] as visited
        grid[i][j] = '0';
        //visiting the all 4 neighbors
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        //here the thing i we do the dfs search 
        // instead of keeping the visited arr just make the '1' to 0
        //looping 
        for(int i = 0 ; i <grid.length ;i++){
            for(int j =0 ; j < grid[0].length;j++){
                //means found the land and '1' is char
                   if(grid[i][j]== '1'){
                    dfs(grid,i,j);
                    //since we making the all visted as 0 no need to worry about getting the dulplicate
                    count++;
                   }
            }
        }
        return count;
    }
}