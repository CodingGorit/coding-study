package test;

/**
 * 使用递归实现二叉树的三种遍历方式
 * 构建一颗完全二叉树
 */
public class Tree {

    private int val;
    private Tree root;
    private Tree left,right;

    /**
     *        1
     *       / \
     *      2   3
     *     / \  /\
     *    4   56  7
     * 前序遍历：中左右   1 2 4 5 3 6 7
     * 中序遍历：左中右   4 2 5 1 6 3 7
     * 后续遍历：左右中   4 5 2 1 6 7 3
     **/
    public static void main(String[] args) {
        // 构建一颗完全二叉树
        Tree root = new Tree();
        root.setVal(1);
        Tree lnode = new Tree();
        lnode.setVal(2);
        Tree rnode = new Tree();
        rnode.setVal(3);

        root.setLeft(lnode);
        root.setRight(rnode);

        Tree l1 = new Tree();
        l1.setVal(4);
        lnode.setLeft(l1);
        Tree r1 = new Tree();
        r1.setVal(5);
        lnode.setRight(r1);

        Tree l2 = new Tree();
        l2.setVal(6);
        rnode.setLeft(l2);
        Tree r2 = new Tree();
        r2.setVal(7);
        rnode.setRight(r2);

        System.out.print("\n===== 先序遍历 =====\n");
        root.frontShow();
        System.out.print("\n===== 中序遍历 =====\n");
        root.midShow();
        System.out.print("\n===== 后序遍历 =====\n");
        root.afterShow();

    }

    // 先序遍历  中左右
    public  void frontShow() {
        System.out.print(val+ " ");
        // 判断不再是自己诶但
        if (left != null) {
            left.frontShow();
        }

        if (right != null) {
            right.frontShow();
        }
    }

    // 中序遍历
    public void midShow() {
        if (left!=null) {
            left.midShow();
        }

        System.out.print(val+ " ");

        if (right!=null) {
            right.midShow();
        }
    }

    // 后续遍历
    public void afterShow() {
        if (left!=null) {
            left.afterShow();
        }

        if (right!=null) {
            right.afterShow();
        }

        System.out.print(val+ " ");
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Tree getRoot() {
        return root;
    }

    public void setRoot(Tree root) {
        this.root = root;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }
}
