/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        Map<Node,Node> map=new HashMap<>();
        return dfs(node,map);
    }
    private Node dfs(Node root,Map<Node,Node> map){
        if(root ==null) return root;
        if(map.containsKey(root)){
            return map.get(root);
        }
        Node node=new Node(root.val);
        map.put(root,node);
        for(Node child:root.neighbors){
            node.neighbors.add(dfs(child,map));
        }
        return node;
    }
}