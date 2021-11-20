public class ArrayStack<E> implements Stack<E> {
    /*
        时间复杂度：
        push → O(1)
        pop → O(1)
        peek → O(1)
        getSize → O(1)
        isEmpty → O(1)
     */
    Array<E> array;
//    从 0 到 1
    public ArrayStack() {
        array = new Array<>();
    }
    public ArrayStack(int capacity) {
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
    public int getCapacity() {
        return array.getCapacity();
    }
//    提供方法，产出功能
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return   array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }
//    项目输出
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
