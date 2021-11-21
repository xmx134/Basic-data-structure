import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    // 二分搜索树是有序的、
    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        调用递归
        root = add(root, e);
    }

    // 内部递归方法
    private Node add(Node node, E e) {
        // 递归终止条件
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }
        // 递归方向
        if (e.compareTo(node.e) < 0) {
            System.out.println("left:" + e);
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            System.out.println("right:" + e);
            node.right = add(node.right, e);
        }
        return node;
    }


    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //    最自然、最常用的遍历：前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //    非递归的前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }

    //  中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //    后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //    层序遍历（广度优先遍历）
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>(); // 利用队列先进先出的特性进行层序遍历
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    //    寻找二分搜索树的最小元素
    public E minimum() {
        if (getSize() == 0) {
            throw new IllegalArgumentException("BST is empty！");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //    寻找二分搜索树的最大元素
    public E maxmum() {
        if (getSize() == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxmum(root).e;
    }

    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    //    删除二分搜索树的最小元素
    public E removeMin() {
        E ret = minimum();

        removeMin(root);

        return ret;
    }

    //    删除掉以node为根的二分搜索树中的最小节点，返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //    删除二分搜索树的最大元素
    public E removeMax() {
        E ret = maxmum();

        removeMax(root);

        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //    删除二分搜索树中的任意节点
    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            throw new IllegalArgumentException("node is Empty!");
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 节点处理 + 指针处理
            // 待删除节点左右子树均不为空的情况下
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMax(node.right);
            successor.left = node.left;
            node.right = null;
            node.left = null;
            return successor;
        }
    }

}
