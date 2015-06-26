/**
 * <p>.</p>
 *
 * @author Magic Joey
 * @version Solution.java 1.0 @2015/6/26 13:51 $
 */

//  Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return true;
        }
        if(p.val!=q.val||hasOneNull(p,q)){
            return false;
        }
        TreeNode pointer = p.right, pointer2 = q.right;
        while(pointer!=null||pointer2!=null){
            if(hasOneNull(pointer,pointer2)||pointer.val!=pointer2.val){
                return false;
            }
        }
        pointer = p.left;
        pointer2 = q.left;
        while(pointer!=null||pointer2!=null){
            if(hasOneNull(pointer,pointer2)||pointer.val!=pointer2.val){
                return false;
            }
        }
        return true;
    }

    public boolean hasOneNull(TreeNode p, TreeNode q){
       return (p==null&&q!=null)||(p!=null&&q==null);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(10);
        System.out.println(new Solution().isSameTree(treeNode,treeNode1));
    }

}