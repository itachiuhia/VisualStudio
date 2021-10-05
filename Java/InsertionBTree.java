import java.util.*;

 class Node{
    int key;
    
    Node right, left;
    Node(int key){
        this.key = key;
        right = left = null;
    }

    static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.key+" - ");
        inorder(root.right);
    }
}


class InsertionBtree{

    static Node root;
    static Node temp = root;

    static void insert(Node temp, int key){
        if(temp  == null){
            root = new Node(key);
            return;
        }

        Queue<Node> q= new LinkedList<Node>();
        q.add(temp);

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }
            else{
                q.add(temp.left);
            }

            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }
            else{
                q.add(temp.right);
            }
        }

    }


    public static void main(String args[]){

        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<5; i++){
            int k = sc.nextInt();
            insert(root, k);
        }

        System.out.println("Btree In Order:\n");
        root.inorder(root);

        sc.close();
        

    }
}