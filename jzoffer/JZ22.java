package cn.gorit.jzoffer;

import cn.gorit.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 二叉树的层次遍历
 */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        // queue 用来保存当前遍历到了哪个节点，一次性把一个节点的左右子节点都入队
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 保存输出的节点
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res; // 构建一个空列表并返回
        TreeNode curr = root; // 保存跟接地那
        queue.offer(root); // 二叉树入队
        // 只要还有节点，就说明没有遍历完
        // 每次从队列出队，然后这个节点左右入队列 （FIFO，就能完成 BFS，然就保存该节点即可）
        while (!queue.isEmpty()) {
            curr = queue.poll(); // 每次队列
            res.add(curr.val);
            if (curr.left != null) { // 有做子节点，则入队
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return res;
    }

    // 递归实现 BFS
    public void bfs(TreeNode root) {
        if (root==null) return;
        if (root.left != null) {
            System.out.println(root.left.val);
        }
        if (root.right != null) {
            System.out.println(root.right.val);
        }
        bfs(root.left);
        bfs(root.right);
    }
}
