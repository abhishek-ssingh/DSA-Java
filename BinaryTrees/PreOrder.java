import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }

    Node(){

    }
}

public class preOrder {

    public static void preOrderTraversal(Node root, ArrayList<Integer> preOrderList){
        if(root==null) return;

        preOrderList.add(root.data);
        preOrderTraversal(root.left, preOrderList);
        preOrderTraversal(root.right, preOrderList);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);

        System.out.println("Preorder is : ");
        for(int i:preOrder){
            System.out.print(i + " ");
        }


    }
}
