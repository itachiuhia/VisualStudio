import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
    static Node root;
    static Node temp = root;

    static void inorder(Node temp){
        if (temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }

    static void delete(Node root, int k){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(root.key == k){
                return;
            }else{
                return;
            }
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null;
        Node keyNode = null;

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.key == k)
                keyNode = temp;
            
            if(temp.left != null){
                q.add(temp.left);

            }

            if(temp.right != null){
                q.add(temp.right);
            }

            if(keyNode  != null){
                int x = temp.key;
                deletedeepestNode(root, temp);
                keyNode.key = x;
            }

        }

    }



    private static void deletedeepestNode(Node root, Node dNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;

        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp == dNode){
                temp = null;
                return;
            }
            if(temp.right != null){
                if(temp.right == dNode){
                    // Node tmp = temp.
                    temp.right = null;
                    return;
                }
                else 
                    q.add(temp.right);
            }
            if(temp.left != null){
                if(temp.right == dNode){
                    temp.right = null;
                    return;
                }else {
                    q.add(temp.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(7);
        root.left.left = new Node(8); 
        root.left.right = new Node(12); 
        // root.right = new Node(9);  
        root.right.left = new Node(15);  
        root.right.right = new Node(18);  

        System.out.println("Inorder Traversal before Deleting");
        inorder(root);
        System.out.println();

        delete(root, 11);

        System.out.println("Inorder Traversal After Deleting");
        inorder(root);
        System.out.println();
        
    }
}