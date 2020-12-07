package cn.gorit.jzoffer;

import cn.gorit.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的镜像
 * 镜像是将根的两个左右子节点进行交换
 */
public class JZ18 {
    // 使用后续遍历，最后处理根节点
    public void Mirror(TreeNode root) {
        if (root==null) return;
        // 直接修改根节点
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        TreeNode curr, temp;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            curr = nodes.poll(); // 元素出队
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) nodes.offer(curr.left);
            if (curr.right != null) nodes.offer(curr.right);
        }
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right =temp;
//            Mirror(root.left);
//            Mirror(root.right);
    }


}
