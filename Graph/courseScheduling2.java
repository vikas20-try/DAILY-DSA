class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //inorder and graph we need to make 
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        //filling the arr with the 
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        //filling the arr 
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]); // next pre[1] - pre[2]
            inDegree[pre[0]]++;
        }
        //making a Queue
        Queue<Integer> queue = new LinkedList<>();
        //checking with the pre and adding whose indegree is 0
        for(int i = 0 ; i < numCourses ;i++){
            if(inDegree[i] == 0) queue.offer(i);
        }
        //here instead of counting the we keep in the int[] with order and count to if it is valid
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            res.add(curr);
            for(int next : graph.get(curr)){
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        return (count == numCourses)?res.stream().mapToInt(Integer::intValue).toArray():new int[]{};
    }
}