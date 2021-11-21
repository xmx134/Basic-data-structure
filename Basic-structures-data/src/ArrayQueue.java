public class ArrayQueue<E> implements Queue<E> {
    /*
        时间复杂度：
        enqueue → O(1)
        dequeue → O(n)
        getFirst → O(1)
        getSize → O(1)
        isEmpty → O(1)
     */
//    内部数据
    Array<E> array;
//    从 0 到 1
    public ArrayQueue() {
        array = new Array<>();
    }
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
//    内部属性探查
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
//    类的特征，产出功能
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }
//    类的介绍
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

}
