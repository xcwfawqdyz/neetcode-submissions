class LRUCache {
    private int cap;
    private Map<Integer,Node> map;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.map=new HashMap<>();
        left=new Node(0,0);
        right=new Node(0,0);
        left.next=right;
        right.pre=left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            addHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
           
        }
        Node newNode=new Node(key,value);
        addHead(newNode);
        map.put(key,newNode);

        if(map.size()>cap){
            Node tail=right.pre;
            remove(tail);
            map.remove(tail.key);
        }
    }
    private void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private void addHead(Node node){
        Node tmp=left.next;
        left.next=node;
        node.pre=left;
        node.next=tmp;
        tmp.pre=node;
    }
}
class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
