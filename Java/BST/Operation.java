package BST;

class Node{
    int key;
    Node right, left ;
    Node(int key){
        this.key = key;
        right = left= null;
    }
}

public class Operation {

    // Node root;
   static  Node root = null;

    static void insert(int key){
        root = insertRec(root, key);
    }
    
    private static Node insertRec(Node root, int key) {
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key){
            root.left = insertRec(root.left, key);
        }
        else if( key > root.key){
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    static Node search(Node tmp, int item){
        if(tmp == null || root.key == item)
            return root;

        if(tmp.key < item){
            search(tmp.left, item);
        }                
        return search(tmp.right, item);
     }

    static Node deleteRec(Node tmp, int item){
        if(tmp == null)
            return tmp;
         
        if(item < tmp.key){
            tmp.left = deleteRec(tmp.left, item);

        }else if( item > tmp.key){
            tmp.right = deleteRec(tmp.right, item);
        }
        else{
            if(tmp.left == null)
                return tmp.right;
            else if (tmp.right == null)
                return tmp.left;
                
             
            tmp.key = minVal(tmp.right);
            
            tmp.right = deleteRec(tmp.right, tmp.key);
        }

        return tmp;
    }
    
    private static int minVal(Node tmp) {
        int minV = tmp.key;
        while(tmp.left != null){
            minV = tmp.left.key;
            tmp = tmp.left;
        }
        return minV;
    }

    static void deleteKey(int item) {
         root = deleteRec(root,item);
    }
    public static void main(String[] args) {
        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(100);
        insert(15);
        insert(60);
        
        inorder(root);
        System.out.println("\n");
        Node item = search(root,40);
        if(item != null){
            System.out.println("item Found");

        }
        else{
            System.out.println("Item Not found");
        }

        // delete operation
        deleteKey(20);

        System.out.println("item Deleted /n");
        inorder(root);


    }

    private static void inorder(Node item) {
        if(item == null)
            return ;
        inorder(item.left);
        System.out.print(item.key+ " ");
        inorder(item.right);

        // Node item = search(root)
    }
}