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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null)
            return ans;
        Deque<TreeNode> q = new LinkedList();
        q.add(root);
        q.add(null);
        List<Integer> l = new ArrayList();
        
        while(!q.isEmpty())
        {
            if(q.peek() == null)
            {
                q.poll();
                if(!q.isEmpty())
                    q.add(null);
                ans.add(l);
                //System.out.println(ans);
                l = new ArrayList();
                continue;
            }
            TreeNode x = q.poll();
            if(x.left != null)
                q.add(x.left);
            if(x.right != null)
                q.add(x.right);
            l.add(x.val);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}