import java.util.ArrayList;
import java.util.List;

public class RedBlackTree <V extends Comparable<V>> {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }
    enum Color{
        BLACK,
        RED
    }

    public Node balance(Node node){
        Node result = node;
        boolean needBalance;
        do {
            needBalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)){
                needBalance = true;
                result = turnRight(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.color == Color.RED){
                needBalance = true;
                result = turnLeft(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED){
                needBalance = true;
                swapColor(result);
            }
        }
        while (needBalance);
        return result;
    }

    private Node turnLeft(Node node){
        Node left = node.left;
        Node middle = left.right;
        left.right = node;
        node.left = middle;
        left.color = node.color;
        node.color =Color.RED;
        return left;
    }

    private Node turnRight(Node node){
        Node right = node.right;
        Node middle = right.left;
        right.left = node;
        node.right = middle;
        right.color = node.color;
        node.color = Color.RED;
        return right;
    }

    private void swapColor(Node node){
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void insert(int value){
        if (root == null){
            root = new Node();
            root.value = value;
        }else{
            insert(root, value);
            root = balance(root);
        }
        root.color = Color.BLACK;
    }

    private void insert(Node node, int value){
        if(node.value != value){
            if(node.value < value){
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                }else{
                    insert(node.right, value);
                    node.right = balance(node.right);
                }
            }else{
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                }else {
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if (node == null){
            return null;
        }
        if (node.value == value){
            return node;
        }
        if(node.value < value){
            return find(node.right, value);
        }else {
            return find(node.left, value);
        }
    }

    public int count(){
        int count =0;
        if (root != null){
            List<Node> line = new ArrayList<>();
            line.add(root);
            while (line.size() > 0) {
                List<Node> nextLine = new ArrayList<>();
                for (Node node :line) {
                    if (node != null){
                        count ++;
                    }
                    if (node.left != null) nextLine.add(node.left);
                    if (node.right != null) nextLine.add(node.right);
                }
                line = nextLine;
            }
            return count;
        }
        return  -1;
    }
}
