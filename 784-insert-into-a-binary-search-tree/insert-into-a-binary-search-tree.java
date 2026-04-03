/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null)return new TreeNode(val);

        TreeNode curr = root;
        while(true){

            if(curr.val < val){
                if(curr.right != null){
                    curr= curr.right;
                }
                else{
                    TreeNode x = new TreeNode(val);
                    curr.right=x;
                    break;
                }
            }
            else{
                if(curr.left != null){
                    curr= curr.left;
                }
                else{
                    TreeNode x= new TreeNode(val);
                    curr.left = x;
                    break;
                }
            }
        }
        return root;
    }
}