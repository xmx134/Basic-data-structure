public class LinkedList<E> {
    /*
     * 链表是一种动态的数据结构，没有索引的概念
     * 时间复杂度：
     * add: O(n) 链表头 O(1)
     * remove: O(n) 链表头 O(1)
     * set: O(n)
     * get: O(n) 链表头 O(1)
     * contains: O(n) 链表头 O(1)
     */

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组越界啦");
        }
        Node prev = dummyHead;
        // 递归形式移动指针
        prev = reAdd(e, index, prev);
        // 指针前移到指定位置
        // for (int i = 0; i < index; i++) {
        // prev = prev.next;
        // }
        // 简化成new Node 形式
        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 递归形式为节点添加元素
    private Node reAdd(E e, int index, Node head) {
        return index == 0 ? head : reAdd(e, index - 1, head.next);
    }

    // 创建虚拟头结点后可以不区分
    public void addFirst(E e) {
        // Node node = new Node(e);
        // node.next = head;
        // head = node;
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界啦");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public void setFirst(E e) {
        set(e, 0);
    }

    public void setLast(E e) {
        set(e, size - 1);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
