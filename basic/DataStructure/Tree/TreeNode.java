package Tree.node;

public class TreeNode {
    // 节点的权
    int val;
    // 左儿子
    TreeNode leftNode;
    // 右儿子
    TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    // 前序遍历
    public void frontShow() {
        // 遍历当前节点的内容 (中左右）
        System.out.print(val + " ");

        // 左节点
        if (leftNode != null) {
            leftNode.frontShow();
        }

        // 右节点
        if (rightNode != null)
            rightNode.frontShow();
    }

    // 中序遍历
    public void midShow() {
        // 左节点
        if (leftNode != null) {
            leftNode.midShow();
        }

        // 遍历当前节点的内容 (中左右）
        System.out.print(val + " ");

        // 右节点
        if (rightNode != null)
            rightNode.midShow();
    }


    public void afterShow() {
        // 左节点
        if (leftNode != null) {
            leftNode.afterShow();
        }

        // 右节点
        if (rightNode != null)
            rightNode.afterShow();

        // 遍历当前节点的内容 (中左右）
        System.out.print(val + " ");
    }

    // 前序查找
    public TreeNode fromSearch(int i) {
        TreeNode target = null;
        // 对比当前节点的值
        if (this.val == i) {
            return this;
        } else {
            // 查找左儿子
            if(leftNode!=null) {
                // 有可能查得到，也有可能查不到， target 还是个 null
                target = leftNode.fromSearch(i);
            }
            // 如果不为空，说明在左儿子中已经找到
            if (target != null) {
                return target;
            }
            // 查找右儿子
            if (rightNode!=null) {
                target = rightNode.fromSearch(i);
            }
        }
        return target;
    }

    // 中序查找
    public TreeNode midSearch(int i) {
        TreeNode target = null;
        if (leftNode!=null) {
            target = leftNode.midSearch(i);
            if (target != null)
                return target;
        }

        if (this.val == i) {
            return this;
        }

        if (rightNode != null) {
            target = rightNode.midSearch(i);
        }

        return target;
    }

    // 后续查找
    public TreeNode afterSearch(int i) {
        TreeNode target = null;
        if (leftNode != null) {
            target = leftNode.afterSearch(i);
            if (target != null)
                return target;
        }

        if (rightNode != null) {
            target = rightNode.afterSearch(i);
        }

        if (this.val == i)
            return this;

        return target;
    }

    // 删除一颗子树
    public void delete(int i) {
        TreeNode parent = this;// 保存当前节点
        // 判断左儿子
        if (parent.leftNode!=null && parent.leftNode.val == i) {
            parent.leftNode = null;
            return;
        }
        // 判断右儿子
        if (parent.rightNode != null && parent.rightNode.val == i) {
            parent.rightNode = null ;
            return;
        }
        // 递归检查并删除左儿子
        parent = leftNode;
        if (parent!=null) {
            parent.delete(i);
        }
        // 递归检查并删除右儿子
        parent = rightNode;
        if (parent!=null) {
            parent.delete(i);
        }
    }
}
