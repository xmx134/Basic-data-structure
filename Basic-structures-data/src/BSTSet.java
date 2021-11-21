public class BSTSet<E extends Comparable<E>> implements Set<E> {
    // 二分搜索树本身就符合集合的需求

    private BST<E> bst;
    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e){
        bst.add(e);
    }

    @Override
    public void remove(E e){
        bst.remove(e);
    }

    @Override
    public boolean contains(E e){
        return bst.contains(e);
    }


}
