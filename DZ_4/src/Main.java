


public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
//        for (int i= 1; i <= 5; i++) {
//            tree.insert(i);
            tree.insert(7);
            tree.insert(5);
            tree.insert(8);
            tree.insert(12);
            tree.insert(2);
           // System.out.println(i);
            System.out.println("Общее количество нод в дереве " + tree.count());
        }
    }
