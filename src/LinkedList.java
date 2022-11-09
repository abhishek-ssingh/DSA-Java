public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public static LinkedList insertNodeAtEnd(LinkedList list, int data){

        Node new_node = new Node(data);

        if(list.head==null){
            list.head = new_node;
        } else {
            Node current = list.head;
            while(current.next!=null) current = current.next;

            current.next = new_node;
        }

        return list;
    }


    public static LinkedList insertAtStart(LinkedList list,int data){
        Node new_node = new Node(data);

        if(list.head==null){
            list.head = new_node;
        }

        Node nextt = list.head;

        list.head = new_node;
        list.head.next = nextt;
        return list;
    }
    public static void printList(LinkedList list){

        if(list.head==null) {
            System.out.println("null");
        } else {
            Node cur = list.head;
            while(cur!=null) {
                System.out.println(cur.data);
                cur = cur.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll = insertNodeAtEnd(ll,1);
        ll = insertNodeAtEnd(ll,2);

        printList(ll);
        ll = insertAtStart(ll,3);
        printList(ll);
    }
}

