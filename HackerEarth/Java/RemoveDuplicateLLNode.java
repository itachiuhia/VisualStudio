package Java;

class Node{
    int data;
    Node next, prev;
    Node(int d){
        data = d;
        prev= next=  null;
    }
    // public void push(int n){
    //     Node ll= new Node(n);

    // }
}

public class RemoveDuplicateLLNode {
    static Node head;
    static Node curr = head;

    public static void push(int d){
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
    }

    static void removeDuplicate(){
        Node curr = head;
        while(curr != null){
            Node tmp = curr;

            while(tmp!= null && tmp.data == curr.data){
                tmp = tmp.next;
            }

            curr.next = tmp;
            curr = curr.next;
        }
    }

    static void printList(){
        Node tmp = head;

        while(tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        push(20);
        push(13);
        push(13);
        push(11);
        push(11);
        push(11);

        printList();

        removeDuplicate();

        printList();
        
        
    }
    
}
