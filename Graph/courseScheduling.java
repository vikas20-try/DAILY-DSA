class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //here use BFS search
        // beacause when we travel from the each node there is a chance we might visit a node more than once 
        // use we keep track of the the course need to completed with 
        // how many times in the hashmap
        // ex if there are [[a,b],[c,b]] then it is a -1 and c - 1
        // when we find it in the search we travel reduce it 
        //checking
        //making adjacney graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        //filling the graph with ArrayList of empty
        for(int i = 0 ; i < numCourses ;i++){
            graph.add(new ArrayList<>());
        }
        //now filling them
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]); // like pre[1] -> pre[0]
            inDegree[pre[0]]++; //mean add the indegree of the pre[0] is +1 
            // it means it need to have X before it comes to the pre[0]
        }
        Queue<Integer> queue = new LinkedList<>();
        //adding the course whose indegree is 0
        for(int i = 0 ; i < numCourses ;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            //running loop to to move to next and reduce the count of inOrder of the next element 
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}