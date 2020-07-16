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
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if(root == null)
            return max;
        Deque<TreeNode> q = new LinkedList<TreeNode>();
        root.val = 1;
        q.add(root);
        q.add(null);
        int dum = 0, prev = 0;
        //TreeNode dummy = new TreeNode();
        while(!q.isEmpty())
        {
            TreeNode x = q.poll();
            if(x == null)
            {
                // if(curr > max)
                //     max = curr;
                int diff = prev-dum+1;
                if(diff > max)
                    max = diff;
                //curr = 0;
                dum = 0;
                prev = 0;
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }
            prev = x.val;
            if(dum == 0)
                dum = x.val;
            // if(x == dummy)
            // {
            //     dum++;
            //     q.add(dummy);
            //     q.add(dummy);
            //     continue;
            // }
            // curr += dum;
            // dum = 0;
            if(x.left != null)
            {
                x.left.val = (2 * x.val);
                q.add(x.left);
            }
            // else
            //     q.add(dummy);
            if(x.right != null)
            {
                x.right.val = (2*x.val)+1;
                q.add(x.right);
            }
            // else
            //     q.add(dummy);
            //curr++;
            //System.out.println("x: " + x.val + ", max: " + max );
        }
        return max;
    }
}