package Tree.node;

/**
 * 创建二叉树
 * 遍历二叉树
 * 二叉树查找
 */
public class TestBinaryTree {
    public static void main(String[] args) {
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
        // 创建一棵树
        BinaryTree binTree = new BinaryTree();
        // 创建节点
        TreeNode root = new TreeNode(1);
        // 根节点给树
        binTree.setRoot(root);

        // 创建左节点
        TreeNode rootL = new TreeNode(2);
        // 设置左节点
        root.setLeftNode(rootL);
        // 创建右节点
        TreeNode rootR = new TreeNode(3);
        // 设置右节点
        root.setRightNode(rootR);

        // 为第二层左节点创建两个子节点
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));


        // 前序遍历
        System.out.print("前序遍历~============\n");
        binTree.frontShow();
        // 中序遍历
        System.out.println("\n中序遍历~=============");
        binTree.midShow();

        System.out.println("\n后续遍历~=============");
        binTree.afterShow();

        System.out.print("\n前序查找");
        // 前序查找
        TreeNode result = binTree.frontSearch(5);
        System.out.println("\n"+result);

        System.out.println("中序查找");
        TreeNode result1 = binTree.midSearch(5);
        System.out.println(result1);

        System.out.println("后续查找");
        TreeNode result3 = binTree.afterSearch(5);
        System.out.println(result3);

        System.out.println("删除二叉树子树");
        binTree.delete(1);
        binTree.frontShow();
    }
}
