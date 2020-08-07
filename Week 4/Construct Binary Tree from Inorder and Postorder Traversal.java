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
    
    int[] in;
    int[] post;
    //value -> index in inorder
    HashMap<Integer, Integer> mp;
    int pIndex;
    
    public TreeNode recur(int start, int end)
    {
        if(start > end)
            return null;
        if(start == end)
        {
            pIndex--;
            TreeNode node = new TreeNode(in[start]);
            return node;
        }
        TreeNode node = new TreeNode(post[pIndex]);
        int index = mp.get(post[pIndex]);
        pIndex--;
        node.right = recur(index+1, end);
        node.left = recur(start, index-1);
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null || inorder.length < 1 || postorder.length < 1)
            return null;
        
        in = inorder;
        post = postorder;
        pIndex = post.length-1;
        mp = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < inorder.length; i++)
        {
            mp.put(inorder[i], i);
        }
        int curr_val = post[pIndex];
        TreeNode root = new TreeNode(curr_val);
        pIndex--;
        
        int index = mp.get(curr_val);
        
        root.right = recur(index+1, postorder.length-1);
        root.left = recur(0, index-1);
        
        return root;
    }
}