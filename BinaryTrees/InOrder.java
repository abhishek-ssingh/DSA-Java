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

public class inOrder {

    public static void inOrder(Node root, ArrayList<Integer> inOrderList){
        if(root==null) return;

        inOrder(root.left, inOrderList);
        inOrderList.add(root.data);
        inOrder(root.right,inOrderList);

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

        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        System.out.println("InOrder is : ");
        for(int i:inOrder){
            System.out.print(i + " ");
        }


    }
}
