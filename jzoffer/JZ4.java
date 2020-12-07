package cn.gorit.jzoffer;

import cn.gorit.datastructure.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 重建二叉树
 */
public class JZ4 {

    /**
     * 传入两个数组，pre 为前序遍历的结果，in 为中序遍历的结果
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        // pre[0] 为根节点
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i=0;i< in.length;i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，将左子树看成一棵二叉树调用该方法，可以得到左子树根结点，即上面根结点的左子结点
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                // 右子树， 注意 copyOfRange 函数，将右子树看成一棵二叉树调用该方法，可以得到右子树根结点，即上面根结点的右子结点
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1, pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}
