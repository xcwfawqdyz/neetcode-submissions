class Node {
    Node[] children=new Node[26];
    boolean endOfWord=false;
}
class WordDictionary {
    private Node root;

    public WordDictionary() {
        root=new Node();
    }

    public void addWord(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            int i=ch-'a';
            if(cur.children[i]==null){
                cur.children[i]=new Node();
            }
            cur=cur.children[i];
        }
        cur.endOfWord=true;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }
    private boolean dfs(Node node,String word,int index){
        Node cur=node;
        for(int i=index;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch=='.'){
                for(int j=0;j<26;j++){
                    if(cur.children[j]!=null && dfs(cur.children[j],word,i+1)){
                        return true;
                    } 
                }
                return false;
            }else{
                int index1=ch-'a';
                if(cur.children[index1]==null){
                    return false;
                } 
                cur=cur.children[index1];
            }
        }
        return cur.endOfWord;
    }
}
