public class LongestLeafPath {

    static int f;

    static int height(Node root){
        if(root== null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);

        if(lh > rh)
            return lh+1;
        return rh+1;
    }   

    static void printPathUtil(Node node, int[] path, int pathLen, int max){
        if(node== null)
            return;
        
            path[pathLen] = node.key;
            pathLen++;

            if(node.left == null && node.right == null){
                if(pathLen == max && ( f == 0 || f == 1)){
                    printArray(path, pathLen);
                    f =2;

                }
            }else{
                printPathUtil(node.left, path, pathLen, max);
                printPathUtil(node.right, path, pathLen, max);
            }


    }

    private static void printArray(int[] path, int pathLen) {
        int i = 0;
        if(f == 0){
            for(i =pathLen-1; i >= 0 ; i--){
                System.out.println(path[i] + " ");
            }
        }
        if(f == 1){
            for(i = 0 ; i < pathLen ; i++){
                System.out.println(path[i] + " ");
            } 
        }
    }

    static void diammeter(Node root){
        if(root == null){
            return;
        }
        int ans = Integer.MIN_VALUE;
        int lh = 0;
        int rh= 0;

         f = 0;
        int hOftree= height(root);
        int[] lpath = new int[100];
        int pathlen =0;

        printPathUtil(root.left, lpath, pathlen,lh);
        System.out.print(root.key + " ");
        int[] rPath = new int[100];
        f = 1;
        printPathUtil(root.right, rPath, pathlen, rh);
    }

    public static void main(String[] args) {
        Node root = null;  
        root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);
        root.left.left.right.left = new Node(9);
        root.right.left.right = new Node(10);

        diammeter(root);
        System.out.println();
    }
    
    


}