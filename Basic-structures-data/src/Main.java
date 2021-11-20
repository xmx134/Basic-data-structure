import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(666,2);
        System.out.println(list);
    }
}
