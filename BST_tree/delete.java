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
    public TreeNode minLeft(TreeNode root){
        //the tree can't be true since we have already checked it
        TreeNode min = null;
        TreeNode curr = root;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //with the help of recursive method
        if (root == null) return null;
        
        if (root.val > key){
            root.left = deleteNode(root.left , key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            //means we found the key
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            //now since both exist we may need to rearrange it
            // when re arranging we have to choose either the highest from the left side or the lowest from the right side of the node
            // for that we will going to make and call a function and recall the delete fn
            TreeNode curr = minLeft(root.right);
            // now we need to make the root and delete the duplicate
            root.val = curr.val;
            root.right = deleteNode(root.right,curr.val);

        }
        return root;
    }
}