class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        Set<String> ans=new HashSet<String>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,trie,i,j,ans);
            }
        }
        return new ArrayList<String>(ans);
    }

    private void dfs(char[][] board, Trie root, int i,int j,Set<String> ans){
        if(!root.children.containsKey(board[i][j])){
            return ;
        }
        char ch=board[i][j];
        root=root.children.get(ch);
        if(!"".equals(root.word)){
            ans.add(root.word);
        }
        board[i][j]='#';
        for(int[] dir:dirs){
            int i1=i+dir[0],j1=j+dir[1];
            if(i1>=0 && i1<board.length && j1>=0 && j1<board[0].length){
                dfs(board,root,i1,j1,ans);
            }
        }
        board[i][j]=ch;
    }

}
class Trie{
    String word;
    Map<Character,Trie> children;
    boolean isWord;
    public Trie(){
        this.word="";
        this.children=new HashMap<>();
    }
    public void insert(String word){
        Trie cur=this;
        for(char ch:word.toCharArray()){
            if(!cur.children.containsKey(ch)){
                cur.children.put(ch,new Trie());
            }
            cur=cur.children.get(ch);
        }
        cur.word=word;
    }
}
