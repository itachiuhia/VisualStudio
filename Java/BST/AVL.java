package BST;

import java.util.Vector;

public class AVL {

    static void storeNode(Vector<Node> n, Node tmp){
        if(tmp != null){
            storeNode(n, tmp.left);
            n.add(tmp);
            storeNode(n, tmp.right);
        }
    }

    static Node buildTree(Node root){
        Vector<Node> node = new Vector<Node>();
        storeNode(node, root.left);

        int n = node.size();
        System.out.println(n);

        return buildBSTutil(node, 0, n-1);
        
    }


    private static Node buildBSTutil(Vector<Node> node, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = (start+end) /2;
        Node tmp = node.get(mid);

        tmp.left = buildBSTutil(node, start, mid -1);
        tmp.right = buildBSTutil(node, mid+1,end);


    
        return tmp;
    }

    // Node tree = new BinaryTree();
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left = new Node(8); 
        root.left.left = new Node(7); 
        root.left.left.left = new Node(6); 
        root.left.left.left.left = new Node(5); 

        Node temp = buildTree(root);
        System.out.println(" Preorder Traversal");
        preorder(temp);
        System.out.println();
        
    }

    private static void preorder(Node temp) {

        if(temp != null){
            System.out.print(temp.key + " ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }
    


    
}