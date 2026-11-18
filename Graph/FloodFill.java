class Solution {
    private void dfs(int[][] image,int color,int i,int j,int[][] visited,int source){
        if(i<0 || i >= image.length || j < 0 || j >= image[0].length || visited[i][j] == 1 || image[i][j] != source) return;
        image[i][j] = color;
        visited[i][j] = 1;
        //going in all 4 directions
        
        dfs(image,color,i+1,j,visited,source);
        dfs(image,color,i-1,j,visited,source);
        dfs(image,color,i,j-1,visited,source);
        dfs(image,color,i,j+1,visited,source);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //let me perform the dfs 
        // and let us keep the
        //here we don;t need to check the every row 
        int[][] visited = new int[image.length][image[0].length];
        int source = image[sr][sc];
        dfs(image,color,sr,sc,visited,source);

        return image;
    }
}