/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList();
        }
        int level = 0;
        List<List<Integer>> res = new ArrayList();
        enumLevelNodes(root,level,res);
        return res;
    }

    public void enumLevelNodes(Node root,int level,List<List<Integer>>res) {
        if(root == null){
            return;
        }
        if(res.size() < level + 1){
           res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        for(Node child: root.children){
           enumLevelNodes(child,level+1,res);
        }  
    }

}