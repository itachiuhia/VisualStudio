package Java;

public class Node{


    int data ;
    Node left,right;

    Node(int data){
        this.data = data;
        right = left = null;
    }
}

public class LCAinBinTree {
    static Node root ;

    public static Node findLCA(Node root, int n1, int n2) {


        return findLCAUtil(root, n1, n2);
    }

    public static Node findLCAUtil(Node node, int n1, int n2) {
        if(node == null)
            return null;
        
        if(node.data == n1 || node.data == n2){
            return node;
        }

        Node l_lca = findLCAUtil(node.left , n1, n2);
        Node r_lca = findLCAUtil(node.right, n1 , n2);

        if(l_lca != null && r_lca != null)
            return node;
        
        return (l_lca != null) ? l_lca: r_lca;


      
    }

    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5) = " +
                        findLCA(root,4, 5).data);
        System.out.println("LCA(root,4, 6) = " +
                        findLCA(root,4, 6).data);
        System.out.println("LCA(root,3, 4) = " +
                         findLCA(root,3, 4).data);
        System.out.println("L   CA(2, 4) = " +
                        findLCA(root,2, 4).data);

        
        
    }

    
}
