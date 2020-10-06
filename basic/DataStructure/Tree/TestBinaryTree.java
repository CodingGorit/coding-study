package Tree.node;

/**
 * ����������
 * ����������
 * ����������
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        /**
         *        1
         *       / \
         *      2   3
         *     / \  /\
         *    4   56  7
         * ǰ�������������   1 2 4 5 3 6 7
         * ���������������   4 2 5 1 6 3 7
         * ����������������   4 5 2 1 6 7 3
         **/
        // ����һ����
        BinaryTree binTree = new BinaryTree();
        // �����ڵ�
        TreeNode root = new TreeNode(1);
        // ���ڵ����
        binTree.setRoot(root);

        // ������ڵ�
        TreeNode rootL = new TreeNode(2);
        // ������ڵ�
        root.setLeftNode(rootL);
        // �����ҽڵ�
        TreeNode rootR = new TreeNode(3);
        // �����ҽڵ�
        root.setRightNode(rootR);

        // Ϊ�ڶ�����ڵ㴴�������ӽڵ�
        rootL.setLeftNode(new TreeNode(4));
        rootL.setRightNode(new TreeNode(5));

        rootR.setLeftNode(new TreeNode(6));
        rootR.setRightNode(new TreeNode(7));


        // ǰ�����
        System.out.print("ǰ�����~============\n");
        binTree.frontShow();
        // �������
        System.out.println("\n�������~=============");
        binTree.midShow();

        System.out.println("\n��������~=============");
        binTree.afterShow();

        System.out.print("\nǰ�����");
        // ǰ�����
        TreeNode result = binTree.frontSearch(5);
        System.out.println("\n"+result);

        System.out.println("�������");
        TreeNode result1 = binTree.midSearch(5);
        System.out.println(result1);

        System.out.println("��������");
        TreeNode result3 = binTree.afterSearch(5);
        System.out.println(result3);

        System.out.println("ɾ������������");
        binTree.delete(1);
        binTree.frontShow();
    }
}
