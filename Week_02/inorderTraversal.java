/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        if(root.left != null){
           inorderTraversal(root.left);
        }
        res.add(root.val);
        if(root.right != null){
           inorderTraversal(root.right);
        }
        return res;
    }
}