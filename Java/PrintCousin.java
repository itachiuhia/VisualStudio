public class PrintCousin {

    static int getLevelUtil(Node root, int k,int level){
        if(root == null)
            return 0;
        if(root.key == k){
            return level;
        }    

        int downLevel = getLevelUtil(root.left, k, level+1);
        if(downLevel != 0)
            return downLevel;
        
        else   
            return getLevelUtil(root.right, k, level+1);

    }


    static void printCousin(Node root, int key){
        int level = getLevelUtil(root, key, 1);
        printCousinUtil(root, key, level);
    }

    private static void printCousinUtil(Node root, int key, int level) {
        if (root == null || level <2){
            return;
        }
        if(level == 2){
            if(root.left.key == key || root.right.key == key)
                return;
            
            if(root.left != null)
                System.out.println(root.left.key + " ");
            
            if( root.right != null)
                System.out.println(root.right.key + " " );    
        }

        else if (level >2){
            printCousinUtil(root.left, key, level-1);
            printCousinUtil(root.right, key, level-1);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printCousin(root, 5);
    }
}