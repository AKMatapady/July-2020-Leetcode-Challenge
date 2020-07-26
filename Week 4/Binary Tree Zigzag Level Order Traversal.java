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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)
            return ans;
        boolean ltor = true;
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> sub = new ArrayList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null)
            {
                if(!ltor)
                {
                    Collections.reverse(sub);
                }
                if(sub.size() > 0)
                    ans.add(sub);
                ltor = !ltor;
                if(!q.isEmpty())
                    q.add(null);
                sub = new ArrayList();
                continue;
            }
            sub.add(curr.val);
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
            
        }
        return ans;
    }
}