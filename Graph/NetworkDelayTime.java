class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //here we are going to use minHeap and dijksstra aglo
        //using map to make graph
        Map<Integer,List<int[]>>graph = new HashMap<>();
        for(int[] time : times){
            int src = time[0],dest = time[1],weight = time[2];
            if(!graph.containsKey(src)){
                graph.put(src,new LinkedList<int[]>());
            }
            graph.get(src).add(new int[]{dest,weight});
        }
            //making a minHeap based one time or weight
            Queue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1]-b[1]);
            //making the visited
            Set<Integer> visited = new HashSet<>();

            //adding the source to the heap
            minHeap.add(new int[]{k,0});//because itt takes 0 time to reach the k 
            int res = 0;
            //performing the bfs on the graph
            while(!minHeap.isEmpty()){
                int[] out = minHeap.poll();
                int src= out[0],srcWeight =out[1];
                if(visited.contains(src)) continue;
                res = srcWeight ;
                visited.add(src);
                //checking the map 
                if(!graph.containsKey(src)) continue;
                //foring throuh the items in the source
                for(int[] adj : graph.get(src)){
                    int tar = adj[0],tarWeight = adj[1];
                    //adding it to heap
                    minHeap.add(new int[]{tar,tarWeight+srcWeight});
                }
            }
        return visited.size() == n ? res : -1;
    }
}