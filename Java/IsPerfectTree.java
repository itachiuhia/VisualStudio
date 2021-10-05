public class IsPerfectTree {
    public static void main(String[] args) {
        Node root = null;  
        root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(30);  
      
        root.left.left = new Node(40);  
        root.left.right = new Node(50);  
        root.right.left = new Node(60);  
        root.right.right = new Node(70);  

        if(isPerfect(root)){
            System.out.print("perfect tree\n");
        }else{
            System.out.print("Not Perfect\n");
        }
    }

    static boolean isPerfect(Node root){
        int d = findDepth(root);
        return isPerfectUtil(root,d, 0);
    }

    static int findDepth(Node node){
        if(node == null){
            return 0;
        }
        int d = 0;
        while(node != null){
            d += 1;
            node = node.left;
        }
        return d;
    }

    private static boolean isPerfectUtil(Node root, int d, int level) {

        // Node tmp;
        // Node temp = root;

        if(root == null){
            return true;

        }

        if(root.left == null && root.right == null){
            return(d == level +1);
        }
        if(root.left == null || root.right == null){
            return false;

        }

        return isPerfectUtil(root.left,d,level+1) && isPerfectUtil(root.right, d, level+1);


        // return false;
    }
    
   
}