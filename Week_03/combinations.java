class Solution {
    int n;
    int k;
    public List<List<Integer>> combine(int n,int k) {
        List<List<Integer>> output = new LinkedList();
        this.n = n;
        this.k = k;
        backTrace(1,new LinkedList());
        return this.output;
    }
    public void backTrace(int first,LinkedList<Integer> curr){
       if(curr.size()== k){
           output.add(new LinkedList(curr));
       }
       for(int i = first;i < n + 1; i++){
           curr.add(i);
           backTrace(i+1,curr);
           curr.removeLast();
       }
    }
}