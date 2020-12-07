package cn.gorit.jzoffer;

import cn.gorit.datastructure.TreeNode;

// 数的子结构
public class JZ17 {
    // 首先找到根节点相等的点
    // 然后再深度优先遍历查看子节点
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if ( root2 == null || root1 == null){
            return false;
        }
        return dfs(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right,root2);
    }
    // 不仅仅要判断结构相等，还要判断值相等
    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2==null) return true;
        if (root1==null) return false;
        return root1.val == root2.val && dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }
}
