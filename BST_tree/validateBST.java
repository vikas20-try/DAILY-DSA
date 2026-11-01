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
    public boolean Valid(TreeNode node , long left , long right){
        if (node == null) return true;

        //checking the left and righ     t boundry 
        if(node.val >= right || node.val <= left) return false;
        boolean lefts = Valid(node.left,left,node.val);
        boolean rights = Valid(node.right,node.val,right);
        return lefts && rights ;

    }
    public boolean isValidBST(TreeNode root) {
        return Valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}