/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node cloneUtl(Node node,HashMap<Node,Node> map){
        //making the new node 
        Node newNode = new Node(node.val);
        //iterating thorgh the neighbours 
        //since we are creating a new clone and it need to be mapped to the old one
        map.put(node,newNode);
        for (Node neighbor : node.neighbors){
            if(!map.containsKey(neighbor)){
                //does not have
                //since it is not cloned we recurivesily clone it 
                newNode.neighbors.add(cloneUtl(neighbor,map));
            }
            else{
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        //making the hashmap to keep track old to new node 
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>(); // old - new
        return cloneUtl(node,map);
    }
}