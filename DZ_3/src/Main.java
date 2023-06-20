
class List {

    static Node tail;
    static Node head;

    static class Node {

        int value;
        Node next;
        Node prev;
    }

    public static void pushFront(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;

    }

    public static void print() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public static void reverse() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.prev;
            currentNode.next = previous;
            currentNode.prev = next;

            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
}
    public class Main {
        public static void main(String[] args) {

            List list = new List();
            for (int i = 1; i <= 5; i++) {
                list.pushFront(i);
            }

            list.print();

            list.reverse();

            list.print();

        }
    }
