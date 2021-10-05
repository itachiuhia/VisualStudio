package BST;


public class DeleteLeaf {


    static Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        else {
            if(root.key > data){
                root.left= insert(root.left, data);
            }else{
                if(root.key < data){
                root.right = insert(root.right, data);
                }
            }
        }

        return root;
    
    }
    private static Node deleteLead(Node root) {
        if(root == null)    
            return null;
        
        if(root.left == null && root.right == null)
            return null;
        
        root.left = deleteLead(root.left);
        root.right = deleteLead(root.right);

        return root;
    }
    


        public static void main(String[] args) {
            Node root = null;
            root = insert(root,20);
            root = insert(root,10);
            insert(root,5);
            insert(root,15);
            insert(root,30);
            insert(root, 25);
            insert(root,35);
            System.out.println("Inorder before deleting");
            inorder(root);
            deleteLead(root);
            System.out.println("inorder after deleting !");
            inorder(root);
        }       

        private static void inorder(Node root) {
            if (root != null){
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }
}