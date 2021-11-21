public class LinkedListQueue<E> implements Queue<E> {

    /*  链表队列：队首入队，队尾出队
        时间复杂度：
        全是 O(1)
     */

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node node){
            this.e = e;
            this.next = node;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;
    private E e;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if (tail == null) {
            tail = new Node(e,null);
            head = tail;
        } else {
            tail.next = new Node(e, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue(){
        if (isEmpty()) {
            throw new IllegalArgumentException("数组越界");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront(){
        if (isEmpty()) {
            throw new IllegalArgumentException("数组越界");
        }
        return head.e;

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("Null tail");
        return res.toString();
    }


}
