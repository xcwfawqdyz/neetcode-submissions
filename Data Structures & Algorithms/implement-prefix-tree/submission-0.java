class PrefixTree {
    private PrefixTree[] tree;
    private boolean stop=false;

    public PrefixTree() {
         tree=new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree current=this;
        for(char ch:word.toCharArray()){
            if(current.tree[ch-'a']==null){
                PrefixTree next=new PrefixTree();
                current.tree[ch-'a']= next;
                current=next;
            }else{
                current=current.tree[ch-'a'];
            }
        }
        current.stop=true;
    }

    public boolean search(String word) {
        PrefixTree current=this;
        for(char ch:word.toCharArray()){
            if(current.tree[ch-'a']==null){
                return false;
            }else{
                current=current.tree[ch-'a'];
            }
        }
        return current.stop;
    }

    public boolean startsWith(String prefix) {
        PrefixTree current=this;
        for(char ch:prefix.toCharArray()){
            if(current.tree[ch-'a']==null){
                return false;
            }else{
                current=current.tree[ch-'a'];
            }
        }
        return true;
    }
}
