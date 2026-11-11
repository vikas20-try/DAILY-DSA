class Solution {
    public boolean isPath(ArrayList<Integer>[] graph , int src,int dest,boolean[] visited){
        if(src == dest) return true;
        //adding the src since we have already checked
        visited[src] = true;
        //running for loop
        for(int nbr: graph[src]){
            if(visited[nbr]==false){
                if(isPath(graph,nbr,dest,visited)) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //before doing the traversal
        ArrayList<Integer>[] graph = new ArrayList[n];
        //this makes n arrayList of size and inside we can add as much we can 
        for(int i = 0;i< n ;i++){
            graph[i] = new ArrayList<>();
            //inserting new empty arraylist to add 
        }
        //making the adjencey 
        for(int[] edge:edges){
            int v1 = edge[0];
            int v2 = edge[1];
            //adding them in each other adj 
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        //visited
        boolean[] visited = new boolean[n];
        //checking through recurively 
       return isPath(graph,source,destination,visited);
    }
}