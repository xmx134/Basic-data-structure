import java.util.Objects;

public class Array<E> {
    private E[] data;
    private int size; // 当前数组的末尾指针

//    从 0 到 1
    public Array() {
        this(10);
    }

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }
//    内部逻辑
    private void resize(int capacity) {
        E[] array = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                array[i] = data[i];
            }
        }
        data = array;
    }
//    核心功能，产出价值
    public void addLast(E item) {
        add(size, item);
    }

    public void addFirst(E item) {
        add(0, item);
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数据越界");
        }
        if (size == data.length) {
            resize(data.length * 2);
        }

        for(int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = item;
        size++;
    }
    public E removeFirst() {
        return removeIndex(0);
    }

    public E removeLast() {
        return removeIndex(size - 1);
    }

    public E removeIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数据越界");
        }
        if (index != size - 1) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
        }
        size --;
        data[size] = null;
        if (size == data.length / 4) { // 防止复杂度震荡 解决方案 Lazy
             resize(data.length / 2);
        }
        return data[index];
    }

    public void removeItem(E item) {
        int index = find(item);
        if (index != -1) {
            removeIndex(index);
        }
    }

    E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数据越界");
        }
        return data[index];
    }

    E getLast() {
        return get(size - 1);
    }

    E getFirst() {
        return get(0);
    }

    void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数据越界");
        }
        data[index] = item;
    }

    public Boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int find(E item) {
        for (int i = 0; i < size; i++) {
            if ((data[i]).equals(item)) {
                return i;
            }
        }
        return -1;
    }
//    项目介绍
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append(('['));
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }
//    探查内部数据
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
