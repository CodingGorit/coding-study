package Tree.node;

/**
 * 链式存储 二叉树
 * 左节点  值  右节点
 * 顺序存储 二叉树
 */

// 链式结构二叉树
public class BinaryTree {

    TreeNode root;

    // 获取根节点
    public TreeNode getRoot() {
        return root;
    }

    // 设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 前序遍历
    public void frontShow() {
        if (root!=null)
            root.frontShow();
        else
            System.out.println("二叉树为空");
    }

    public void midShow() {
        if (root!=null)
            root.frontShow();
        else
            System.out.println("二叉树为空");
    }

    public void afterShow() {
        if (root!=null)
            root.frontShow();
        else
            System.out.println("二叉树为空");
    }

    public TreeNode frontSearch(int i) {
        return root.fromSearch(5);
    }

    public TreeNode midSearch(int i) {
        return root.midSearch(i);
    }

    public TreeNode afterSearch(int i) {
        return root.afterSearch(i);
    }

    public void delete(int i) {
        if (root.val == i) {
            root = null;
        } else {
            root.delete(i);
        }
    }
}
