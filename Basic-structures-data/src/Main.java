import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(2);
        bst.add(1);
        bst.add(6);
        bst.preOrder();
        bst.add(4);
        bst.add(5);
        bst.add(3);
        bst.preOrder();
    }
}
