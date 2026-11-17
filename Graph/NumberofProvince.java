class Solution {
    private void dfs(int[][] isConnected,int node,int[] visited){
        //marking the current node as visited
        visited[node] = 1;
        //for the node iterating through its node
        for(int i = 0 ; i < isConnected[node].length ;i++){
            if(isConnected[node][i] == 1 && visited[i] !=1){
                ///calling the dfs again
                dfs(isConnected,i,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        //making an arr to visited to not iterate over and over
        int[] visited = new int[isConnected.length];
        for(int i = 0 ; i < isConnected.length ;i++){
            if(visited[i]!=1){
                dfs(isConnected,i,visited);
                count++;
            }
        }
        return count;
    }
}