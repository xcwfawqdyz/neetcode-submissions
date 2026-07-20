class TimeMap {
    private Map<String,List<Pair<Integer,String>>> keyStore;
    public TimeMap() {
        keyStore=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values=keyStore.getOrDefault(key,new ArrayList<>());
        int l=0,r=values.size()-1;
        String result="";
        while(l<=r){
            int mid=l+(r-l)/2;
            if(values.get(mid).getKey()==timestamp){
                return values.get(mid).getValue();
                
            }else if(values.get(mid).getKey()>timestamp){
                r=mid-1;
            }else{
                l=mid+1;
            }

        }
        return r>=0?values.get(r).getValue():"";
    }

    private static class Pair<K,V>{
        private final K key;
        private final V value;
        public Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
}
