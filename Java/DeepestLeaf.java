public class DeepestLeaf {
    static int result = 0;
    public static void main(String[] args) {

        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.right.left = new Node(5); 
        root.right.right = new Node(6); 
        root.right.left.right = new Node(7); 
        root.right.right.right = new Node(8); 
        root.right.left.right.left = new Node(9); 
        root.right.right.right.right = new Node(10); 

        deepestLeafS(root);

        System.out.println(result);
    }

    private static void deepestLeafS(Node node) {
        int level = 0;
        deepestLeafutil(node, 0, level, false);
    }

    private static void deepestLeafutil(Node node, int lvl, int level, boolean isLeft) {
        // Node root;
        // Node result;


        if(node == null){
            return ;

        }
        if(isLeft!= false && node.left == null && node.right == null && lvl> level){
            result = node.key;
            level = lvl;
        }

        deepestLeafutil(node.left, lvl+1 , level, isLeft);
        deepestLeafutil(node.right, lvl+1, level, isLeft);

        // System.out.println(level);



    }


}